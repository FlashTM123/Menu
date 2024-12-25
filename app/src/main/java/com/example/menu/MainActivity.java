package com.example.menu;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ListView lvMenu;

    private List<Menu> data;

    private MyAdapter myAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        lvMenu = findViewById(R.id.lvMenu);
        data = new ArrayList<>();

        data.add(new Menu("Bun Cha", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQ51FV6xeA-HUP9_SAN8UbAWY13zFFS-nQuaA&s", Double.parseDouble("30000")));
        data.add(new Menu("Bun Bo Hue", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQ18vvZHV7PVjLBJxmupKEW_6FJ7bZfs4mczA&s", Double.parseDouble("25000")));
        data.add(new Menu("Pho bo", "https://mccormick.widen.net/content/2bitmso2z0/original/vietnamese_beef_noodle_soup_800x800.jpg", Double.parseDouble("40000")));

        myAdapter = new MyAdapter(this, data);
        lvMenu.setAdapter(myAdapter);

        lvMenu.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, data.get(position).getName(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}