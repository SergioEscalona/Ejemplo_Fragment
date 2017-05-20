package sergioescalona.ejemplo_fragment.Activities;

import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telecom.Call;

import sergioescalona.ejemplo_fragment.Fragments.DataFragment;
import sergioescalona.ejemplo_fragment.Fragments.DetailsFragment;
import sergioescalona.ejemplo_fragment.R;

public class MainActivity extends FragmentActivity implements DataFragment.DataListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    @Override
    public void sendData(String text) {
        //llamar al metodo renderizeText de el DetailsFragment, pasando el texto que
        //recibimos por parametro en este mismo metodo.
        //creamos una instancia al fragmento que queremos comunicarnos
        DetailsFragment detailsFragment = (DetailsFragment) getSupportFragmentManager().findFragmentById(R.id.detailsFragment);
        //llamamos al metodo renderText.
        detailsFragment.renderText(text);
    }
}
