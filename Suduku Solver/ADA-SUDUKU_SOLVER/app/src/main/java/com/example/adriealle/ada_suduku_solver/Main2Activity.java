package com.example.adriealle.ada_suduku_solver;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import static java.lang.StrictMath.max;

public class Main2Activity extends AppCompatActivity {

    EditText weight, price,inputs,size;
    TextView ans;
    Button solve;
    String an;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        solve=(Button)findViewById(R.id.button);
        weight=(EditText) findViewById(R.id.editText6);
        price=(EditText)findViewById(R.id.editText5);
        size=(EditText)findViewById(R.id.editText9);
        inputs=(EditText)findViewById(R.id.editText8);
        ans=(TextView)findViewById(R.id.textView3);


solve.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        int N,W;
        int[] wt= new int[5];
        int val[]=new int[5];

        String o[]=weight.getText().toString().split(" ");
        String l[]=price.getText().toString().split(" ");
        N=Integer.parseInt(inputs.getText().toString());
        W=Integer.parseInt(size.getText().toString());
        for(int i=0;i<N;i++)
        {
            wt[i]=Integer.parseInt(o[i]);
            val[i]=Integer.parseInt(l[i]);
        }

        //ans.setText("0/1 Knapsack table\n");
        knapSack(W,wt, val, N);



    }
});

    }



        int knapSack(int W, int wt[], int val[], int N)
        {
            int[][] V = new int[N + 1][W + 1];
            for (int col = 0; col <= W; col++) {
                V[0][col] = 0;
            }

            for (int row = 0; row <= N; row++) {
                V[row][0] = 0;
            }
            for (int item=1;item<=N;item++){

                for (int weight=1;weight<=W;weight++){

                    if (wt[item-1]<=weight){
                        V[item][weight]=Math.max (val[item-1]+V[item-1][weight-wt[item-1]], V[item-1][weight]);
                    }
                    else {
                        V[item][weight]=V[item-1][weight];
                    }
                }
            }
            //Printing the matrix
            for (int[] rows : V) {
                for (int col : rows) {
                    ans.append("\t"+col);
                }
                ans.append("\n");
            }
            ans.append("\n\t ANS Choose: "+V[N][W]);
            return 0;

        } public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu, menu);//Menu Resource, Menu
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.item1:
                Intent k =new Intent(Main2Activity.this,MainActivity.class);
                startActivity(k);
                return true;
            case R.id.item2:
                Toast.makeText(getApplicationContext(),"Knapsack", Toast.LENGTH_LONG).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}