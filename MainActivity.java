// Case 1:

public class MainActivity extends AppCompatActivity implements MyDialog.ItemClickEventListener {
    AppCompatTextView myTextView;
    MyDialog myDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myTextView = findViewById(R.id.tv_data);
        AppCompatButton dialogBtn = findViewById(R.id.btn_dialog);
        dialogBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myDialog = new MyDialog();
                myDialog.show(getSupportFragmentManager(), null);
            }
        });

    }

    @Override
    public void btnOkClick(String data) {
        myTextView.setText(data);
        myDialog.dismiss();
    }

    @Override
    public void btnCancelClick() {
        myDialog.dismiss();
    }
}
