package sergioescalona.ejemplo_fragment.Fragments;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import sergioescalona.ejemplo_fragment.R;

public class DataFragment extends Fragment {

    private EditText textData;
    private Button buttonSend;
    private DataListener callback;


    public DataFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(Context context) {
        //a este fragment le llega el contexto de la activity
        super.onAttach(context);
        try{
            //el callback es igual al contexto que le llega a OnAttach
            //hay que comprobar que la activity está implementando la interfaz
            //cada vez que hagas algo en la activity principal, se va a volcar en este callback
            //a traves de la interfaz DataListener.
        callback = (DataListener) context;
        }catch(Exception e){

        throw new ClassCastException(context.toString() + "should implement DataListener");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_data, container, false);

        //Capturamos los elementos de la UI.
        textData = (EditText) view.findViewById(R.id.editTextData);
        buttonSend = (Button) view.findViewById(R.id.buttonSend);

        buttonSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendText(textData.getText().toString());
            }
        });

        return view;
    }

    private void sendText (String text){
        //llamamos a nuestra interfaz a través de callback para acceder al método que nos interesa
        //que es sendData
        callback.sendData(text);
        //enviamos el texto.
    }

    public interface DataListener {
        void sendData(String text);
    }

}
