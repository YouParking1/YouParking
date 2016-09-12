package troy.com.youparking;

import android.app.AlertDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.support.annotation.MainThread;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

/**
 * Created by acous on 8/28/2016.
 */
public class BackgroundWorker extends AsyncTask<String, Void, String> {
    public AsyncResponse delegate = null;
    private boolean showAlert = false;

    Context context;
    AlertDialog alertDialog;
    public BackgroundWorker(Context ctx) {
        context = ctx;
    }

    @Override
    protected String doInBackground(String... params) {
        String type = params[0];
        if (type.equals("login"))  {
            String login_url = "http://www.troyparking.com/login.php";
            showAlert = true;
            try {
                String email = params[1];
                String password = params[2];
                URL url = new URL(login_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                OutputStream outputStream = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                String post_data = URLEncoder.encode("Email", "UTF-8")+"="+URLEncoder.encode(email, "UTF-8")+"&"
                        +URLEncoder.encode("Password", "UTF-8")+"="+URLEncoder.encode(password, "UTF-8");
                bufferedWriter.write(post_data);
                bufferedWriter.flush();
                bufferedWriter.close();
                outputStream.close();
                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "iso-8859-1"));
                String result = "";
                String line;
                while((line = bufferedReader.readLine()) != null) {
                    result += line;
                }
                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();
                return result;
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else if (type.equals("hold")) { //Send email, points, car, latitude, longitude, comments, and school
            try {
                String hold_url = "http://www.troyparking.com/holdspot.php";
                String email = User.email;
                String points = params[1];
                String car = params[2];
                String latitude = params[3];
                String longitude = params[4];
                String comments = params[5];
                String school = User.school;
                URL url = new URL(hold_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                OutputStream outputStream = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                String post_data = URLEncoder.encode("email", "UTF-8")+"="+URLEncoder.encode(email, "UTF-8")+"&"
                        +URLEncoder.encode("points", "UTF-8")+"="+URLEncoder.encode(points, "UTF-8")+"&"
                        +URLEncoder.encode("car", "UTF-8")+"="+URLEncoder.encode(car, "UTF-8")+"&"
                        +URLEncoder.encode("comments", "UTF-8")+"="+URLEncoder.encode(comments, "UTF-8")+"&"
                        +URLEncoder.encode("latitude", "UTF-8")+"="+URLEncoder.encode(latitude, "UTF-8")+"&"
                        +URLEncoder.encode("longitude", "UTF-8")+"="+URLEncoder.encode(longitude, "UTF-8")+"&"
                        +URLEncoder.encode("school", "UTF-8")+"="+URLEncoder.encode(school, "UTF-8");
                bufferedWriter.write(post_data);
                bufferedWriter.flush();
                bufferedWriter.close();
                outputStream.close();
                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "iso-8859-1"));
                String result = "";
                String line;
                while ((line = bufferedReader.readLine()) != null) {
                    result += line;
                }
                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();
                System.out.println("HEY IM IN HERE ");
                return result;
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }


        }
        return null;
    }

    @Override
    protected void onPostExecute(String result) {
            alertDialog.setMessage(result);
            alertDialog.show();
            delegate.processFinish(result);

    }

    @Override
    protected void onPreExecute() {
        alertDialog = new AlertDialog.Builder(context).create();
        alertDialog.setTitle("Status");
    }

    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
    }
}
