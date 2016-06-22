package bonvoyage.database;

import android.content.Context;
import android.database.sqlite.SQLiteException;
import android.preference.DialogPreference;
import android.util.AttributeSet;
import android.widget.TextView;
import android.widget.Toast;

import se.paulo.nackademin.examen.bonvoyage.R;


public class ResetAllDatabase extends DialogPreference {

    private TextView alertText;
    BonvoyageDB dbDropAllDatabase;



    public ResetAllDatabase(Context context, AttributeSet attrs) {
        super(context, attrs);

        /** If i need to create a more complex AlertDialog, I can create a new Layout and then use setDialogLayoutResource */
        //setDialogLayoutResource(R.layout.delete_database);
    }


    @Override
    protected void onDialogClosed(boolean positiveResult) {
        super.onDialogClosed(positiveResult);

        if(positiveResult){
            String msg = "Drop and re-create table was successfully!";

            try {
                dbDropAllDatabase = new BonvoyageDB(getContext());
                dbDropAllDatabase.dropAllDataBase();
                Toast.makeText(getContext(), msg, Toast.LENGTH_LONG).show();

            }catch (SQLiteException e){
                Toast.makeText(getContext(), "Drop and re-create table did not worked.." + e.getMessage(), Toast.LENGTH_LONG).show();
            }


        }else {
            //do nothing
        }

    }
}