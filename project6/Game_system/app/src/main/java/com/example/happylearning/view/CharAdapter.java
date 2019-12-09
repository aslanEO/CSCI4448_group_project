package com.example.happylearning.view;
import android.content.Context;
import android.media.MediaPlayer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import com.example.happylearning.R;
import com.example.happylearning.models.CharInfo;
import java.util.List;

public class CharAdapter extends ArrayAdapter<CharInfo> {

    /*
     * Description:
     * We defined a ArrayAdapter for list view to display image of IPA symbol and pronunciation.
     */

    private int resourceId;
    private Context context;
    private MediaPlayer mediaPlayer;

    /* Adapter Pattern */
    public CharAdapter(Context context, int text_view_id, List<CharInfo> objects) {
        super(context, text_view_id,objects);
        this.context = context;
        resourceId = text_view_id;
    }

    @Override
    public View getView(int position,  View convertView, ViewGroup parent) {
        final CharInfo charInfo = getItem(position);
        View view= LayoutInflater.from(getContext()).inflate(resourceId, parent,false);
        ImageView CharImage =  view.findViewById(R.id.char_image); //view_holder
        ImageButton char_audio = view.findViewById(R.id.audio);
        CharImage.setImageResource(charInfo.getImageId()); //set image information
        char_audio.setOnClickListener(new View.OnClickListener() {  //set playing audio for this image button
            @Override
            public void onClick(View view) {
                mediaPlayer=MediaPlayer.create(context,charInfo.getAudioId());
                mediaPlayer.start();
            }

        });
        return view;
    }
}