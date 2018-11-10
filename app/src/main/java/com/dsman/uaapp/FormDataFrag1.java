package com.dsman.uaapp;

import android.app.DatePickerDialog;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.Observer;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import java.util.Locale;


//TODO Tienes activity, dentro de tu fragmento, cargas el Framgneto 1 por defecto, y cuando le des al botón, cargas fragmento 2

public class FormDataFrag1 extends FragmentActivity {
    @BindView(R.id.etName)
    EditText mName;
    @BindView(R.id.etSurname)
    EditText mSurname;
    @BindView(R.id.etSurname2)
    EditText mSurname2;
    @BindView(R.id.etBirthday)
    EditText mBirthday;
    @BindView(R.id.etAddress)
    EditText mAddress;
    @BindView(R.id.etPostalCode)
    EditText mPostalCode;
    @BindView(R.id.etCity)
    EditText mCity;
    @BindView(R.id.spPhoneType)
    Spinner mPhoneType;
    @BindView(R.id.etPhone)
    EditText mPhone;
    @BindView(R.id.btnSave)
    Button btnSave;
    @BindView(R.id.tilName)
    TextInputLayout layoutName;
    @BindView(R.id.tilSurname)
    TextInputLayout layoutSurname;
    @BindView(R.id.tilSurname2)
    TextInputLayout layoutSurname2;
    @BindView(R.id.tilBirthday)
    TextInputLayout layoutBirthday;
    @BindView(R.id.tilAddress)
    TextInputLayout layoutAddress;
    @BindView(R.id.tilPostalCode)
    TextInputLayout layoutPostalCode;
    @BindView(R.id.tilCity)
    TextInputLayout layoutCity;
    @BindView(R.id.tilPhone)
    TextInputLayout layoutPhone;
    @BindView(R.id.btnclearDate)
    Button btnClearDate;

    private Intent intent_send;
    private Intent intent_receive;


    private User user;

    MutableLiveData<String> nameLD = new MutableLiveData<>();
    private String name;
    MutableLiveData<String> surnameLD = new MutableLiveData<>();
    private String surname;
    MutableLiveData<String> surname2LD = new MutableLiveData<>();
    private String surname2;
    MutableLiveData<String> birthdayLD = new MutableLiveData<>();
    private String birthday;
    MutableLiveData<String> addressLD = new MutableLiveData<>();
    private String address;
    MutableLiveData<String> postalCodeLD = new MutableLiveData<>();
    private String postalCode;
    MutableLiveData<String> cityLD = new MutableLiveData<>();
    private String city;

    private String phoneType;
    MutableLiveData<String> phoneLD = new MutableLiveData<>();
    private String phone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_form_data);
        //Creación ButterKnife
        ButterKnife.bind(this);
        user = new User();
        intent_receive = this.getIntent();
        if (intent_receive != null) {
            user = (User) intent_receive.getParcelableExtra(MainActivity.USER);
        }


        textListener();
        onClickbirthday();
        clearDate();
        onClickedSave();

    }


    Calendar myCalendar = Calendar.getInstance();
    DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {

        @Override
        public void onDateSet(DatePicker view, int year, int monthOfYear,
                              int dayOfMonth) {

            myCalendar.set(Calendar.YEAR, year);
            myCalendar.set(Calendar.MONTH, monthOfYear);
            myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
            updateLabel();
        }

    };


    public void textListener() {

        mName.addTextChangedListener(enableButtonSave);
        mSurname.addTextChangedListener(enableButtonSave);
        mSurname2.addTextChangedListener(enableButtonSave);
        mBirthday.addTextChangedListener(enableButtonSave);
        mAddress.addTextChangedListener(enableButtonSave);
        mPostalCode.addTextChangedListener(enableButtonSave);
        mCity.addTextChangedListener(enableButtonSave);
        mPhone.addTextChangedListener(enableButtonSave);

    }

    public TextWatcher enableButtonSave = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

            name = mName.getText().toString();
            nameLD.postValue(name);
            nameLD.observe(FormDataFrag1.this, new Observer<String>() {
                @Override
                public void onChanged(@NonNull String sName) {
                    if (!sName.isEmpty()) {
                        layoutName.setHelperText(" ");
                    }

                }
            });
            surname = mSurname.getText().toString();
            surnameLD.postValue(surname);
            surnameLD.observe(FormDataFrag1.this, new Observer<String>() {
                @Override
                public void onChanged(@NonNull String sSurname) {
                    if (!sSurname.isEmpty()) {
                        layoutSurname.setHelperText(" ");
                    }
                }
            });
            surname2 = mSurname2.getText().toString().trim();
            surname2LD.postValue(surname2);
            surname2LD.observe(FormDataFrag1.this, new Observer<String>() {
                @Override
                public void onChanged(@NonNull String sSurname2) {
                    if (!sSurname2.isEmpty()) {
                        layoutSurname2.setHelperText(" ");
                    }
                }
            });
            address = mAddress.getText().toString();
            addressLD.postValue(address);
            addressLD.observe(FormDataFrag1.this, new Observer<String>() {
                @Override
                public void onChanged(@NonNull String sText) {
                    if (!sText.isEmpty()) {
                        layoutAddress.setHelperText(" ");
                    }
                }
            });

            birthday = mBirthday.getText().toString();
            birthdayLD.postValue(birthday);
            birthdayLD.observe(FormDataFrag1.this, new Observer<String>() {
                @Override
                public void onChanged(@NonNull String sText) {
                    if (!sText.isEmpty()) {
                        layoutBirthday.setHelperText(" ");
                    }
                }
            });
            postalCode = mPostalCode.getText().toString();
            postalCodeLD.postValue(postalCode);
            postalCodeLD.observe(FormDataFrag1.this, new Observer<String>() {
                @Override
                public void onChanged(@NonNull String sText) {
                    if (!sText.isEmpty()) {
                        layoutPostalCode.setHelperText(" ");
                    }
                }
            });
            city = mCity.getText().toString();
            cityLD.postValue(city);
            cityLD.observe(FormDataFrag1.this, new Observer<String>() {
                @Override
                public void onChanged(@NonNull String sText) {
                    if (!sText.isEmpty()) {
                        layoutCity.setHelperText(" ");
                    }
                }
            });
            phoneType = mPhoneType.getSelectedItem().toString();

            phone = mPhone.getText().toString();
            phoneLD.postValue(phone);
            phoneLD.observe(FormDataFrag1.this, new Observer<String>() {
                @Override
                public void onChanged(@NonNull String sText) {
                    if (!sText.isEmpty()) {
                        layoutPhone.setHelperText(" ");
                    }
                }
            });
            btnSave.setEnabled(enableButton());

        }

        @Override
        public void afterTextChanged(Editable s) {
        }
    };

    public boolean enableButton() {
        if (!name.isEmpty() || !surname.isEmpty() || !surname2.isEmpty() || !birthday.isEmpty() || !address.isEmpty() ||
                !postalCode.isEmpty() || !city.isEmpty() || !phone.isEmpty()) {

            return true;
        } else {

            return false;
        }

    }

    public boolean allDone() {
        if (!name.isEmpty() && !surname.isEmpty() && !surname2.isEmpty() && !birthday.isEmpty() && !address.isEmpty() &&
                !postalCode.isEmpty() && !city.isEmpty() && !phone.isEmpty()) {

            return true;
        } else {

            return false;
        }

    }

    public void textListenerError() {
        if (name.equals("")) {
            layoutName.setHelperTextEnabled(true);
            layoutName.setError("You forgot to write your " + layoutName.getHint());
        }

        if (surname.equals("")) {
            layoutSurname.setHelperTextEnabled(true);
            layoutSurname.setError("You forgot to write your " + layoutSurname.getHint());
        }
        if (surname2.equals("")) {
            layoutSurname2.setHelperTextEnabled(true);
            layoutSurname2.setError("You forgot to write your " + layoutSurname2.getHint());
        }
        if (birthday.equals("")) {
            layoutBirthday.setHelperTextEnabled(true);
            layoutBirthday.setError("You forgot to write your " + layoutBirthday.getHint());
        }
        if (address.equals("")) {
            layoutAddress.setHelperTextEnabled(true);
            layoutAddress.setError("You forgot to write your " + layoutAddress.getHint());
        }
        if (postalCode.equals("")) {
            layoutPostalCode.setHelperTextEnabled(true);
            layoutPostalCode.setError("You forgot to write your " + layoutPostalCode.getHint());
        }
        if (city.equals("")) {
            layoutCity.setHelperTextEnabled(true);
            layoutCity.setError("You forgot to write your " + layoutCity.getHint());
        }
        if (phone.equals("")) {
            layoutPhone.setHelperTextEnabled(true);
            layoutPhone.setError("You forgot to write your " + layoutPhone.getHint());
        }
    }

    //Botón de reseteo de Birthday
    public void clearDate() {
        btnClearDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mBirthday.setText("");
            }
        });
    }

    public void onClickedSave() {
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (enableButton()) {
                    textListenerError();

                }
                if (allDone()) {
                    Toast.makeText(FormDataFrag1.this,"Entra en el Else",Toast.LENGTH_SHORT).show();

                    if (findViewById(R.id.Frag1) != null) {

                        // However, if we're being restored from a previous state,
                        // then we don't need to do anything and should return or else
                        // we could end up with overlapping fragments.
                        if (savedInstanceState != null) {
                            return;
                        }

                        // Create a new Fragment to be placed in the activity layout
                        HeadlinesFragment firstFragment = new HeadlinesFragment();

                        // In case this activity was started with special instructions from an
                        // Intent, pass the Intent's extras to the fragment as arguments
                        firstFragment.setArguments(getIntent().getExtras());

                        // Add the fragment to the 'fragment_container' FrameLayout
                        getSupportFragmentManager().beginTransaction()
                                .add(R.id.Frag1, firstFragment).commit();
                    }


                    user.setName(mName.getText().toString());
                    user.setSurname(mSurname.getText().toString());
                    user.setSurname2(mSurname2.getText().toString());
                    user.setAddress(mAddress.getText().toString());
                    user.setPostalcode(mPostalCode.getText().toString());
                    user.setCity(mCity.getText().toString());
                    user.setPhonetype(mPhoneType.getSelectedItem().toString());
                    user.setPhone(mPhone.getText().toString());


                    //TODO Crear pantalla Personal Data
            // intent_send = new Intent(this, );
            //intent_send.putExtra(MainActivity.USER, user);
            //startActivity(intent_send);
                }
            }
        });

    }


    public void onClickbirthday() {
        mBirthday.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                new DatePickerDialog(getLayoutInflater().getContext(), date, myCalendar
                        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();

            }
        });

    }

    private void updateLabel() {
        String myFormat = "dd/MM/yyyy"; //In which you need put here
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);
        mBirthday.setText(sdf.format(myCalendar.getTime()));
    }
}