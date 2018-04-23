package com.example.adriealle.ada_suduku_solver;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.lang.reflect.Field;


public class MainActivity extends AppCompatActivity {
    EditText ans;
    Button solve;
    int y;
    private EditText[][] text;

   static int grid[][] = {
            { 3, 0, 6, 5, 0, 8, 4, 0, 0 }, //
            { 5, 2, 0, 0, 0, 0, 0, 0, 0 }, //
            { 0, 8, 7, 0, 0, 0, 0, 3, 1 }, //
            { 0, 0, 3, 0, 1, 0, 0, 8, 0 }, //
            { 9, 0, 0, 8, 6, 3, 0, 0, 5 }, //
            { 0, 5, 0, 0, 9, 0, 6, 0, 0 }, //
            { 1, 3, 0, 0, 0, 0, 2, 5, 0 }, //
            { 0, 0, 0, 0, 0, 0, 0, 7, 4 }, //
            { 0, 0, 5, 2, 0, 6, 3, 0, 0 } };
    static class Cell {

        int row, col;

        public Cell(int row, int col) {
            super();
            this.row = row;
            this.col = col;
        }

        @Override
        public String toString() {
            return "Cell [row=" + row + ", col=" + col + "]";
        }
    };
    static boolean isValid(Cell cell, int value) {

        if (grid[cell.row][cell.col] != 0) {
            throw new RuntimeException(
                    "Cannot call for cell which already has a value");
        }

        for (int c = 0; c < 9; c++) {
            if (grid[cell.row][c] == value)
                return false;
        }

        for (int r = 0; r < 9; r++) {
            if (grid[r][cell.col] == value)
                return false;
        }

        int x1 = 3 * (cell.row / 3);
        int y1 = 3 * (cell.col / 3);
        int x2 = x1 + 2;
        int y2 = y1 + 2;

        for (int x = x1; x <= x2; x++)
            for (int y = y1; y <= y2; y++)
                if (grid[x][y] == value)
                    return false;
        return true;
    }
    static Cell getNextCell(Cell cur) {

        int row = cur.row;
        int col = cur.col;

        col++;

        if (col > 8) {
            col = 0;
            row++;
        }
        if (row > 8)
            return null; // reached end

        Cell next = new Cell(row, col);
        return next;
    }
  static boolean solve(Cell cur) {
        if (cur == null)
            return true;
        if (grid[cur.row][cur.col] != 0) {
            return solve(getNextCell(cur));
        }
        for (int i = 1; i <= 9; i++) {
            boolean valid = isValid(cur, i);

            if (!valid) // i not valid for this cell, try other values
                continue;

            // assign here
            grid[cur.row][cur.col] = i;

            boolean solved = solve(getNextCell(cur));
            if (solved)
                return true;
            else
                grid[cur.row][cur.col] = 0;
        }

        return false;
    }
    public void initSolver(){
        text = new EditText[10][10];
        for(int i = 1; i<10; i++){
            for(int j = 1; j<10; j++){
                String property = "EditText" + Integer.toString(i) + Integer.toString(j);
                Field f = null;
                try {
                    f = R.id.class.getField(property);
                } catch (SecurityException e) {
                    Toast.makeText(this, "Unknown error #1!", Toast.LENGTH_LONG).show();
                } catch (NoSuchFieldException e) {
                }
                int rid = 0;

                try {
                    rid = f.getInt(R.id.class);
                } catch (IllegalArgumentException e) {
                    Toast.makeText(this, "Unknown error #2!", Toast.LENGTH_LONG).show();
                } catch (IllegalAccessException e) {
                    Toast.makeText(this, "Unknown error #3!", Toast.LENGTH_LONG).show();
                }

                text[i][j] = (EditText) findViewById ( rid );
                y=grid[i-1][j-1];
                text[i][j].setPadding(10, 1, 1, 1);
                text[i][j].setText(""+y);
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initSolver();
       ans= (EditText)findViewById(R.id.textView);
        solve= (Button) findViewById(R.id.button2);

        solve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                grid[1][1]=Integer.parseInt(text[2][2].getText().toString());
                grid[1][4]=Integer.parseInt(text[2][5].getText().toString());
                grid[1][7]=Integer.parseInt(text[2][8].getText().toString());
                grid[4][1]=Integer.parseInt(text[5][2].getText().toString());
                grid[4][4]=Integer.parseInt(text[5][5].getText().toString());
                grid[4][7]=Integer.parseInt(text[5][8].getText().toString());
                grid[1][1]=Integer.parseInt(text[8][2].getText().toString());
                grid[7][4]=Integer.parseInt(text[8][5].getText().toString());
                grid[7][7]=Integer.parseInt(text[8][8].getText().toString());
                boolean solved = solve(new Cell(0, 0));
                if (!solved) {
                    ans.setText("Cannot be solved.");
                    return;
                }

               ans.setText("SOLUTION\n");
                for(int i = 1; i<10; i++){
                    for(int j = 1; j<10; j++){
                        String property = "EditText" + Integer.toString(i) + Integer.toString(j);
                        Field f = null;
                        try {
                            f = R.id.class.getField(property);
                        } catch (SecurityException e) {
                            Toast.makeText(MainActivity.this, "Unknown error #1!", Toast.LENGTH_LONG).show();
                        } catch (NoSuchFieldException e) {
                        }
                        int rid = 0;

                        try {
                            rid = f.getInt(R.id.class);
                        } catch (IllegalArgumentException e) {
                            Toast.makeText(MainActivity.this, "Unknown error #2!", Toast.LENGTH_LONG).show();
                        } catch (IllegalAccessException e) {
                            Toast.makeText(MainActivity.this, "Unknown error #3!", Toast.LENGTH_LONG).show();
                        }

                        text[i][j] = (EditText) findViewById ( rid );
                        y=grid[i-1][j-1];
                      text[i][j].setPadding(10, 1, 1, 1);
                        text[i][j].setText(""+y);

                }
            }
        }
});
    }
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu, menu);//Menu Resource, Menu
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.item1:
                Toast.makeText(getApplicationContext(),"Sudoku", Toast.LENGTH_LONG).show();
                return true;
            case R.id.item2:

                Intent k =new Intent(MainActivity.this,Main2Activity.class);
                startActivity(k);
                 return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}