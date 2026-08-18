package com.github.nukc.stateview

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.graphics.Canvas
import android.os.Build
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.annotation.IntDef
import androidx.annotation.LayoutRes
import androidx.collection.ArraySet
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.NestedScrollingChild
import androidx.core.view.NestedScrollingParent
import androidx.core.view.ScrollingView
import androidx.core.view.ViewCompat

/**
 * @author Nukc.
 */
class StateView : View {

    @IntDef(EMPTY, RETRY, LOADING)
    @kotlin.annotation.Retention(AnnotationRetention.SOURCE)
    annotation class ViewType

    var emptyResource = 0
    var retryResource = 0
    var loadingResource = 0

    var emptyView: View? = null
        set(value) {
            setView(EMPTY, value)
            field = value
        }
    var retryView: View? = null
        set(value) {
            setView(RETRY, value)
            field = value
            setupRetryClickListener()
        }
    var loadingView: View? = null
        set(value) {
            setView(LOADING, value)
            field = value
        }

    private val addSet = ArraySet<@ViewType Int>()

    var inflater: LayoutInflater? = null
    var onRetryClickListener: OnRetryClickListener? = null
    var onInflateListener: OnInflateListener? = null

    var animatorProvider: AnimatorProvider? = null
        set(value) {
            field = value
            reset(emptyView)
            reset(loadingView)
            reset(retryView)
        }

    constructor(context: Context) : this(context, null)

    constructor(context: Context, attrs: AttributeSet?) : this(context, attrs, 0)

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        val a = context.obtainStyledAttributes(attrs, R.styleable.StateView)
        emptyResource = a.getResourceId(R.styleable.StateView_emptyResource, 0)
        retryResource = a.getResourceId(R.styleable.StateView_retryResource, 0)
        loadingResource = a.getResourceId(R.styleable.StateView_loadingResource, 0)
        a.recycle()

        if (emptyResource == 0) {
            emptyResource = R.layout.base_empty
        }
        if (retryResource == 0) {
            retryResource = R.layout.base_retry
        }
        if (loadingResource == 0) {
            loadingResource = R.layout.base_loading
        }

        visibility = GONE
        setWillNotDraw(true)
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        setMeasuredDimension(0, 0)
    }

    @SuppressLint("MissingSuperCall")
    override fun draw(canvas: Canvas?) {
    }

    override fun dispatchDraw(canvas: Canvas?) {}

    override fun setVisibility(visibility: Int) {
        setVisibility(emptyView, visibility)
        setVisibility(retryView, visibility)
        setVisibility(loadingView, visibility)
    }

    private fun setVisibility(view: View?, visibility: Int) {
        if (view != null && visibility != view.visibility) {
            if (animatorProvider != null) {
                startAnimation(view)
            } else {
                view.visibility = visibility
            }
        }
    }

    fun showContent() {
        visibility = GONE
    }

    fun showEmpty() = showView(EMPTY)

    fun showRetry() = showView(RETRY)

    fun showLoading() = showView(LOADING)

    /**
     * show the state view
     */
    private fun showView(@ViewType viewType: Int): View {
        var view = when (viewType) {
            EMPTY -> emptyView
            RETRY -> retryView
            LOADING -> loadingView
            else -> throw IllegalArgumentException("Invalid viewType: $viewType")
        }
        // if the view is null, inflate layoutResource
        if (view == null) {
            val layoutResource = when (viewType) {
                EMPTY -> emptyResource
                RETRY -> retryResource
                LOADING -> loadingResource
                else -> NO_ID
            }
            view = inflate(layoutResource, viewType)
            when (viewType) {
                EMPTY -> emptyView = view
                RETRY -> retryView = view
                LOADING -> loadingView = view
            }
        } else if (addSet.contains(viewType)) {
            // if the view not in the parent
            addToParent(viewType, parent as ViewGroup, view)
        }
        setVisibility(view, VISIBLE)
        hideViews(view)
        return view
    }

    /**
     * hide other views after show view
     */
    private fun hideViews(showView: View) {
        when {
            emptyView === showView -> {
                setVisibility(loadingView, GONE)
                setVisibility(retryView, GONE)
            }
            loadingView === showView -> {
                setVisibility(emptyView, GONE)
                setVisibility(retryView, GONE)
            }
            else -> {
                setVisibility(emptyView, GONE)
                setVisibility(loadingView, GONE)
            }
        }
    }

    private fun startAnimation(view: View) {
        val toShow = view.visibility == GONE
        val animator: Animator? = if (toShow) animatorProvider!!.showAnimation(view) else animatorProvider!!.hideAnimation(view)
        if (animator == null) {
            view.visibility = if (toShow) VISIBLE else GONE
            return
        }
        animator.addListener(object : AnimatorListenerAdapter() {
            override fun onAnimationEnd(animation: Animator) {
                super.onAnimationEnd(animation)
                if (!toShow) {
                    view.visibility = GONE
                }
            }

            override fun onAnimationStart(animation: Animator) {
                super.onAnimationStart(animation)
                if (toShow) {
                    view.visibility = VISIBLE
                }
            }
        })
        animator.start()
    }

    /**
     * reset view's property
     * 不然多次设置 [animatorProvider] 后视图动画会混乱
     */
    private fun reset(view: View?) {
        if (view != null) {
            view.translationX = 0f
            view.translationY = 0f
            view.alpha = 1f
            view.rotation = 0f
            view.scaleX = 1f
            view.scaleY = 1f
        }
    }

    /**
     * set [view], add to [getParent] when [showView]
     */
    private fun setView(@ViewType viewType: Int, view: View?) {
        val viewParent = parent
        if (viewParent is ViewGroup) {
            // if the view is already in the parent, no operation
            if (viewParent.indexOfChild(view) > NO_ID) {
                return
            }
            when (viewType) {
                EMPTY -> emptyView
                RETRY -> retryView
                LOADING -> loadingView
                else -> throw IllegalArgumentException("Invalid viewType: $viewType")
            }?.let {
                viewParent.removeViewInLayout(it)
            }

            addSet.add(viewType)
        }
    }

    private fun inflate(@LayoutRes layoutResource: Int, @ViewType viewType: Int): View {
        val viewParent = parent
        return if (viewParent is ViewGroup) {
            if (layoutResource != 0) {
                val factory: LayoutInflater = inflater ?: LayoutInflater.from(context)
                val view = factory.inflate(layoutResource, viewParent, false)
                addToParent(viewType, viewParent, view)
            } else {
                throw IllegalArgumentException("StateView must have a valid layoutResource")
            }
        } else {
            throw IllegalStateException("StateView must have a non-null ViewGroup viewParent")
        }
    }

    private fun addToParent(@ViewType viewType: Int, viewParent: ViewGroup, view: View): View {
        addSet.remove(viewType)

        val index = viewParent.indexOfChild(this)
        // 防止还能触摸底下的 View
        view.isClickable = true
        // 先不显示
        view.visibility = GONE
        ViewCompat.setZ(view, ViewCompat.getZ(this))
        if (layoutParams != null) {
            if (viewParent is RelativeLayout) {
                val lp = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                    RelativeLayout.LayoutParams(layoutParams as RelativeLayout.LayoutParams)
                } else {
                    RelativeLayout.LayoutParams(layoutParams)
                }
                viewParent.addView(view, index, lp)
            } else if (Injector.constraintLayoutAvailable && viewParent is ConstraintLayout) {
                val source = layoutParams as ConstraintLayout.LayoutParams
                val lp = ConstraintLayout.LayoutParams(layoutParams as ViewGroup.LayoutParams)
                lp.leftToLeft = source.leftToLeft
                lp.rightToRight = source.rightToRight
                lp.topToTop = source.topToTop
                lp.bottomToBottom = source.bottomToBottom
                viewParent.addView(view, index, lp)
            } else {
                viewParent.addView(view, index, layoutParams)
            }
        } else {
            viewParent.addView(view, index)
        }
        if (loadingView != null && retryView != null && emptyView != null) {
            viewParent.removeViewInLayout(this)
        }
        onInflateListener?.onInflate(viewType, view)
        return view
    }

    private fun setupRetryClickListener() {
        retryView?.setOnClickListener {
            if (onRetryClickListener != null) {
                showLoading()
                retryView!!.postDelayed({
                    onRetryClickListener?.onRetryClick()
                }, 400)
            }
        }
    }

    /**
     * Listener used to receive a notification after the RetryView is clicked.
     *
     * @see onRetryClickListener
     */
    interface OnRetryClickListener {
        fun onRetryClick()
    }

    /**
     * Listener used to receive a notification after a StateView has successfully
     * inflated its layout resource.
     *
     * @see onInflateListener
     */
    interface OnInflateListener {
        /**
         * @param view The inflated View.
         */
        fun onInflate(@ViewType viewType: Int, view: View?)
    }

    companion object {
        const val EMPTY = 0x00000000
        const val RETRY = 0x00000001
        const val LOADING = 0x00000002

        internal val TAG = StateView::class.java.simpleName

        @JvmStatic
        fun inject(activity: Activity): StateView {
            return inject(activity.window.decorView.findViewById<View>(android.R.id.content))
        }

        @JvmStatic
        fun inject(view: View): StateView {
            return when (view) {
                is ViewGroup -> inject(view)
                else -> wrap(view)
            }
        }

        @JvmStatic
        fun inject(viewGroup: ViewGroup): StateView {
            if (viewGroup is LinearLayout || viewGroup is ScrollView || viewGroup is AdapterView<*> ||
                    (viewGroup is ScrollingView && viewGroup is NestedScrollingChild) ||
                    (viewGroup is NestedScrollingParent && viewGroup is NestedScrollingChild)) {
                return if (viewGroup.parent is ViewGroup) {
                    wrap(viewGroup)
                } else {
                    Injector.wrapChild(viewGroup)
                }
            }

            // match the viewGroup
            val stateView = StateView(viewGroup.context)
            viewGroup.addView(stateView, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT)
            return stateView
        }

        @JvmStatic
        fun wrap(view: View): StateView {
            val parent = view.parent
            if (parent is ViewGroup) {
                if (Injector.constraintLayoutAvailable && parent is ConstraintLayout) {
                    return Injector.matchViewIfParentIsConstraintLayout(parent, view)
                }
                if (parent is RelativeLayout) {
                    return Injector.matchViewIfParentIsRelativeLayout(parent, view)
                }

                // will increase the layout level
                parent.removeView(view)
                val wrap = FrameLayout(view.context)
                parent.addView(wrap, view.layoutParams)
                wrap.addView(view, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT)
                val stateView = StateView(view.context)
                wrap.addView(stateView, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT)
                Injector.setStateListAnimator(stateView, view)
                return stateView
            }
            throw ClassCastException("view.getParent() must be ViewGroup")
        }

    }
}
