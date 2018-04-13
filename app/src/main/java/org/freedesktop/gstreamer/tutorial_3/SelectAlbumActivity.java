package org.freedesktop.gstreamer.tutorials.tutorial_3;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Environment;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.SimpleAdapter;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SelectAlbumActivity extends Fragment {
    private GridView gridView;
    @Override
    public void onAttach(Context context)
    {
        super.onAttach(context);

        //取得MainActivity的方法，將文字放入text字串
//        MainActivity mMainActivity = (MainActivity) activity;
//        text = mMainActivity.getLessonOneText();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        //導入Tab分頁的Fragment Layout
        return inflater.inflate(R.layout.activity_select_album, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState)
    {


        super.onActivityCreated(savedInstanceState);

//        //取得TextView元件並帶入text字串
//        TextView mText = (TextView) getView().findViewById(R.id.text);
//        mText.setText(text);
//
//        //取得ImageView元件並帶入指定圖片
//        ImageView mImg = (ImageView) getActivity().findViewById(R.id.img);
//        mImg.setImageResource(R.drawable.lesson1_img);


        List<Map<String, Object>> items = new ArrayList<>();
        List<String> allImage = getList(android.os.Environment.getExternalStoragePublicDirectory("RoomiiPicture"));
        Bitmap mypic;
        for (int i = 0; i < allImage.size(); i++) {
            Map<String, Object> item = new HashMap<>();
            mypic = getBitmapFromSDCard("RoomiiPicture/"+allImage.get(i));
            item.put("image", mypic);
            items.add(item);
        }

        SimpleAdapter adapter = new SimpleAdapter(this.getActivity(),
                items, R.layout.roomiipicture, new String[]{"image"},
                new int[]{R.id.image});


        adapter.setViewBinder(new SimpleAdapter.ViewBinder() {

            @Override
            public boolean setViewValue(View view, Object data,
                                        String textRepresentation) {
                if(view instanceof ImageView && data instanceof Bitmap){
                    ImageView i = (ImageView)view;
                    i.setImageBitmap((Bitmap) data);
                    return true;
                }
                return false;
            }
        });

        gridView = (GridView)getView().findViewById(R.id.myGridview);
        gridView.setNumColumns(3);
        gridView.setAdapter(adapter);
//        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                Toast.makeText(MainActivity.this, "你選擇了" + imgText[position], Toast.LENGTH_SHORT).show();
//            }
//        });

    }

    private static Bitmap getBitmapFromSDCard(String file)
    {
        try
        {
            String sd = Environment.getExternalStorageDirectory().toString();
            Bitmap bitmap = BitmapFactory.decodeFile(sd + "/" + file);
            return bitmap;
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return null;
        }
    }

    private List<String> getList(File parentDir) {

        ArrayList<String> inFiles = new ArrayList<String>();
        String[] fileNames = parentDir.list();

        for (String fileName : fileNames) {
            if (fileName.toLowerCase().endsWith(".jpg")) {
                inFiles.add(fileName);
            }
        }
        return inFiles;
    }
}
