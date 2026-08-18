package multispace.multiapp.clone.util;

import android.content.Context;
import android.util.Log;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class OooO {
    public static final String OooO00o = "ZIP";

    public static void OooO00o(Context context, String str, String str2) throws Exception {
        ZipInputStream zipInputStream = new ZipInputStream(context.getAssets().open(str));
        while (true) {
            ZipEntry nextEntry = zipInputStream.getNextEntry();
            if (nextEntry == null) {
                zipInputStream.close();
                return;
            }
            String name = nextEntry.getName();
            if (nextEntry.isDirectory()) {
                File file = new File(str2 + File.separator + name.substring(0, name.length() - 1));
                if (file.exists()) {
                    return;
                } else {
                    file.mkdirs();
                }
            } else {
                String str3 = OooO00o;
                String str4 = str2 + File.separator + name;
                Log.e(str3, str4);
                File file2 = new File(str4);
                if (!file2.exists()) {
                    Log.e(str3, "Create the file:" + str2 + File.separator + name);
                    file2.getParentFile().mkdirs();
                    file2.createNewFile();
                }
                FileOutputStream fileOutputStream = new FileOutputStream(file2);
                byte[] bArr = new byte[1024];
                while (true) {
                    int i = zipInputStream.read(bArr);
                    if (i == -1) {
                        break;
                    }
                    fileOutputStream.write(bArr, 0, i);
                    fileOutputStream.flush();
                }
                fileOutputStream.close();
            }
        }
    }

    public static List<String> OooO0O0(String str) {
        File[] fileArrListFiles = new File(str).listFiles();
        if (fileArrListFiles == null) {
            Log.e("ZIP", "empty dir");
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (File file : fileArrListFiles) {
            arrayList.add(file.getAbsolutePath());
        }
        return arrayList;
    }
}