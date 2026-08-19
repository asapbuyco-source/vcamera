import re, os

R = r"C:\Users\pc\vcfix\vc213_reskin\res"

def edit(path, old, new, count=1):
    p = os.path.join(R, path)
    c = open(p, encoding="utf-8").read()
    if old not in c:
        print("MISS:", path, "->", old[:60])
        return
    c = c.replace(old, new, count)
    open(p, "w", encoding="utf-8", newline="\n").write(c)
    print("OK:", path)

# 1. labels
edit("values/strings.xml", '<string name="app_name">VCamera</string>', '<string name="app_name">Perez Live</string>')
edit("values/strings.xml", '<string name="vc_app_name">VCamera</string>', '<string name="vc_app_name">Perez Live</string>')
edit("values/strings.xml", '<string name="vc_app_name_all">Virtual Camera</string>', '<string name="vc_app_name_all">Perez Live Cam</string>')

# 2. palette
edit("values/colors.xml", '<color name="background">#ffffffff</color>', '<color name="background">#ff1e2430</color>')
edit("values/colors.xml", '<color name="primary">#ff009688</color>', '<color name="primary">#ff3b82f6</color>')
edit("values/colors.xml", '<color name="primary_dark">#ff009688</color>', '<color name="primary_dark">#ff2a6fd6</color>')
edit("values/colors.xml", '<color name="primary_light">#ff009688</color>', '<color name="primary_light">#ff3b82f6</color>')
edit("values/colors.xml", '<color name="primary_text">#ff333333</color>', '<color name="primary_text">#fff5f7f9</color>')
edit("values/colors.xml", '<color name="secondary_text">#ff999999</color>', '<color name="secondary_text">#ff8a94a6</color>')

# 3. theme
edit("values/styles.xml",
     '<style name="Theme.Main" parent="@style/Theme.MaterialComponents.Light.NoActionBar">',
     '<style name="Theme.Main" parent="@style/Theme.MaterialComponents.NoActionBar">')
edit("values/styles.xml", '<item name="actionMenuTextColor">@color/primary_text</item>',
     '<item name="actionMenuTextColor">@color/primary_text</item>\n'
     '        <item name="android:colorBackground">@color/background</item>\n'
     '        <item name="colorSurface">@color/background</item>\n'
     '        <item name="colorOnBackground">@color/primary_text</item>\n'
     '        <item name="colorOnSurface">@color/primary_text</item>\n'
     '        <item name="android:windowBackground">@color/background</item>')
edit("values/styles.xml",
     '<style name="WelcomeTheme" parent="@style/Theme.AppCompat.Light.NoActionBar">',
     '<style name="WelcomeTheme" parent="@style/Theme.AppCompat.NoActionBar">')

# 4. splash
edit("drawable/splash.xml", '<solid android:color="@android:color/white" />', '<solid android:color="#ff1e2430" />')

# 5. white backgrounds -> dark
for f in ("layout/search_view.xml", "layout/vc_activity_camera_settings.xml"):
    p = os.path.join(R, f)
    c = open(p, encoding="utf-8").read()
    c = re.sub(r'android:background="(@color/white|#fff[^0-9a-f]|#ffffff|@android:color/white)"',
               'android:background="@color/background"', c)
    open(p, "w", encoding="utf-8", newline="\n").write(c)
    print("OK:", f)

# 6. hard black text -> light
for f in ("layout/activity_pay.xml", "layout/bonuspack_bubble.xml", "layout/period_pw_2.xml"):
    p = os.path.join(R, f)
    c = open(p, encoding="utf-8").read()
    c = re.sub(r'android:textColor="(#ff000000|#000000|#de000000|@android:color/black)"',
               'android:textColor="@color/primary_text"', c)
    open(p, "w", encoding="utf-8", newline="\n").write(c)
    print("OK:", f)
