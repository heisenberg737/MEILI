package global.meili.meili;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class guides extends Fragment implements View.OnClickListener{
    ImageView manual_guide,automated_guide;


    public guides() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_guides, container, false);
        manual_guide=view.findViewById(R.id.manual_guides_icon);
        automated_guide=view.findViewById(R.id.automated_guides_icon);
        automated_guide.setOnClickListener(this);
        manual_guide.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.manual_guides_icon)
        {
            FragmentManager fragmentManager=getFragmentManager();
            FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.MainContent,new POV(),null).addToBackStack(null).commit();
        }
        else if(v.getId()==R.id.automated_guides_icon)
            Toast.makeText(getContext(),"Under Development",Toast.LENGTH_SHORT);
    }
}
