package id.sch.smktelkom_mlg.tugas01.xir4013.tugas01;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    TextView tvWelcome, tvhasil, tvGender, tvSpeciality;
    EditText etName, etEmail;
    RadioGroup rgGender;
    RadioButton rbMale, rbFemale;
    CheckBox cbHiphop, cbEDM, cbRnb, cbetc;
    Spinner spinner;
    Button buttonOk;
    ImageView ivGambar;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvWelcome = (TextView) findViewById(R.id.tvWelcome);
        tvhasil =(TextView) findViewById(R.id.tvhasil);
        tvGender = (TextView) findViewById(R.id.tvGender);
        tvSpeciality = (TextView) findViewById(R.id.tvSpeciality);
        etName =(EditText) findViewById(R.id.etName);
        etEmail = (EditText) findViewById(R.id.etEmail);
        rgGender =(RadioGroup) findViewById(R.id.rgGender);
        rbMale = (RadioButton) findViewById(R.id.rbMale);
        rbFemale = (RadioButton) findViewById(R.id.rbFemale);
        cbHiphop = (CheckBox) findViewById(R.id.cbHiphop);
        cbEDM = (CheckBox) findViewById(R.id.cbEDM);
        cbRnb = (CheckBox) findViewById(R.id.cbRnB);
        cbetc = (CheckBox) findViewById(R.id.cbetc);
        spinner = (Spinner) findViewById(R.id.spinner);
        ivGambar = (ImageView) findViewById(R.id.ivGambar);
        buttonOk = (Button) findViewById(R.id.buttonOK);

        findViewById(R.id.buttonOK).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                doClick();
                doProcess();
            }
        });
    }

    private void doProcess() {
        if (isValid()){
            String name = etName .getText().toString();
            String email = etEmail.getText().toString();
            tvhasil.setText("Your Registration has been sent!");

        }
    }

    private boolean isValid() {
        boolean valid = true;

        String name = etName.getText().toString();
        String email = etEmail.getText().toString();

        if(name.isEmpty()){
            etName.setError("Please fill the name!");
            valid =false;
        }
        else if (email.isEmpty())
            {
                etEmail.setError("Please fill the email!");
                valid = false;
            }
        else {
            tvhasil.setError(null);
        }
        return valid;
        }


    private void doClick() {

        String hasil = "Your Registration has been sent!";

        if (rbMale.isChecked())
        {
            hasil = rbMale.getText().toString();
        }
        else if (rbFemale.isChecked())
        {
            hasil = rbFemale.getText().toString();
        }

        if (hasil==null)
        {
            tvhasil.setText("Please fill it all");
        }
        else
        {
            tvhasil.setText("Your Registration has been sent!");
        }

        if (cbHiphop.isChecked()) hasil+=cbHiphop.getText();
        if (cbRnb.isChecked()) hasil+=cbRnb.getText();
        if (cbEDM.isChecked()) hasil+=cbEDM.getText();
        if (cbetc.isChecked()) hasil+=cbetc.getText();
        if (hasil.isEmpty()) hasil+="No entri";

        StringBuilder builder = new StringBuilder();
        builder.append(spinner.getSelectedItem().toString());

    }
}
