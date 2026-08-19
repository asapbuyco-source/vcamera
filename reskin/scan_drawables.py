import re, os

R = r"C:\Users\pc\vcfix\vc213_reskin\res"
light = r'#(?:ff)?(f[0-9a-f]{5}|e[0-9a-f]{5}|d[0-9a-f]{5}|c[0-9a-f]{5})'
hits = []
for dirpath, dirs, files in os.walk(os.path.join(R, "drawable")):
    for f in files:
        if not f.endswith(".xml"):
            continue
        p = os.path.join(dirpath, f)
        c = open(p, encoding="utf-8").read()
        if re.search(light, c, re.I):
            m = re.findall(r'<solid[^>]*color="([^"]+)"', c)
            if m:
                hits.append((f, m[:4]))
for f, m in hits[:60]:
    print(f, m)
print("drawable files with light solids:", len(hits))
