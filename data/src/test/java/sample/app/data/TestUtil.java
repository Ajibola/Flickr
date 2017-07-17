package sample.app.data;

import android.util.Log;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * A helper class to load test resources
 */
public class TestUtil {

    private static final String TAG = TestUtil.class.getSimpleName();

    public String loadResourceFile(String fileName) {
        try {
            File file = new File(getClass().getClassLoader().getResource(fileName).getFile());
            FileInputStream fileInputStream = new FileInputStream(file);
            BufferedReader reader = new BufferedReader(new InputStreamReader(fileInputStream));
            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                sb.append(line).append("\n");
            }
            reader.close();
            fileInputStream.close();
            return sb.toString();
        } catch (FileNotFoundException e) {
            Log.d(TAG, App.getContext().getString(R.string.test_file_not_found));
        } catch (IOException e) {
            Log.d(TAG, App.getContext().getString(R.string.test_file_io_exception));
        }

        return null;
    }
}
