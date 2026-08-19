import struct
import zipfile
import shutil

JAR = r"C:\Users\pc\Desktop\vcamera\opensdk\src\main\assets\moon.jar"
BAK = r"C:\Users\pc\vcfix\moon.jar.orig"
TARGET = "lib/arm64-v8a/libmultiapp.so"
PATCH_OFF = 0xA9F40  # vaddr == file offset (first LOAD segment starts at 0)
PATCH_BYTES = struct.pack("<III", 0x52800020, 0xD503201F, 0xD503201F)  # mov w0,#1; nop; nop

if not __import__("os").path.exists(BAK):
    shutil.copy2(JAR, BAK)
    print("backup ->", BAK)

zin = zipfile.ZipFile(JAR)
items = []
patched = False
for info in zin.infolist():
    data = zin.read(info.filename)
    if info.filename == TARGET:
        orig = data[PATCH_OFF:PATCH_OFF + 12]
        print("before:", orig.hex())
        data = data[:PATCH_OFF] + PATCH_BYTES + data[PATCH_OFF + 12:]
        print("after :", data[PATCH_OFF:PATCH_OFF + 12].hex())
        patched = True
    items.append((info, data))
zin.close()

assert patched, "target not found in jar"
zout = zipfile.ZipFile(JAR, "w", zipfile.ZIP_DEFLATED)
for info, data in items:
    zout.writestr(info, data)
zout.close()
print("moon.jar patched")