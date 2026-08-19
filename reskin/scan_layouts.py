import re, os, sys

root = r'C:\Users\pc\vcfix\vc213_reskin\res'
counts = {}
for dirpath, dirs, files in os.walk(os.path.join(root, 'layout')):
    for f in files:
        if not f.endswith('.xml'):
            continue
        p = os.path.join(dirpath, f)
        c = open(p, encoding='utf-8').read()
        hits = re.findall(r'android:background="(@color/white|#fff[^0-9a-f]|#ffffff|@android:color/white)"', c)
        if hits:
            counts[f] = len(hits)
total = sum(counts.values())
print('layouts with white bg:', counts)
print('total:', total)

# also text colors that are dark (black) which would be invisible on dark bg
dark_text = {}
for dirpath, dirs, files in os.walk(os.path.join(root, 'layout')):
    for f in files:
        if not f.endswith('.xml'):
            continue
        p = os.path.join(dirpath, f)
        c = open(p, encoding='utf-8').read()
        hits = re.findall(r'android:textColor="(#ff000000|#000000|#de000000|@android:color/black)"', c)
        if hits:
            dark_text[f] = len(hits)
print('layouts with hard black text:', dark_text)
print('total black text:', sum(dark_text.values()))
