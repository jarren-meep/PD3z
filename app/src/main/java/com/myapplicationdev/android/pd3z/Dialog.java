package com.myapplicationdev.android.pd3z;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatDialogFragment;

public class Dialog extends AppCompatDialogFragment {
    private EditText updateStatus;
    private DialogListener listener;
    @Override
    public android.app.Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.layout_dialog, null);

        builder.setView(view);
        builder.setTitle("Update Status");
        builder.setPositiveButton("Update!", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String updateText = updateStatus.getText().toString();
                listener.update(updateText);
            }
        });
        updateStatus = view.findViewById(R.id.updateStatus);
        return builder.create();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            listener = (DialogListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString() + "Must implement listener");
        }
    }

    public interface DialogListener {
        void update(String updateText);
    }
}
