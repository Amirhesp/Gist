
// Case 1: Alert dialog with onCreateView method:

public class MyDialog extends DialogFragment {

    public final static String DIALOG_KEY = "data";
    ItemClickEventListener itemClickEventListener;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        itemClickEventListener = (ItemClickEventListener) context;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_my_dialog, null, false);
        AppCompatEditText myText = view.findViewById(R.id.et_Dialog);
        AppCompatButton btnOk = view.findViewById(R.id.btn_ok);
        AppCompatButton btnCancel = view.findViewById(R.id.btn_cancel);
        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                itemClickEventListener.btnOkClick(myText.getText().toString());
            }
        });

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                itemClickEventListener.btnCancelClick();
            }
        });
        return view;
    }

    public interface ItemClickEventListener {
        void btnOkClick(String data);
        void btnCancelClick();
    }
}
