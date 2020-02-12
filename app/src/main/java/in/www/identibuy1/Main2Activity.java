package in.www.identibuy1;
import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import com.andremion.floatingnavigationview.FloatingNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import android.os.Handler;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import com.google.android.material.navigation.NavigationView;
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.Menu;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;
public class Main2Activity extends AppCompatActivity {
    private AppBarConfiguration mAppBarConfiguration;
    FloatingActionButton fab;
    RecyclerView recyclerView,recyclerView1,recyclerView2;
    RecyclerRecentAdapter recyclerRecentAdapter;
    private static final int CAMERAPERMISSIONCODE = 1001;
    Context context;
    RecyclerViewAdapter recyclerViewAdapter;
    ArrayList<String> arrayList = new ArrayList<>();
    ArrayList<String> arrayList1 = new ArrayList<>();
    ArrayList<String> arrayList2 = new ArrayList<>();
    Context c;
    LinearLayoutManager llmV, llmH;
    private RecyclerView.LayoutManager layoutManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        recyclerView = findViewById(R.id.recyler1);
        recyclerView1=findViewById(R.id.rectrecycler);
        recyclerView2=findViewById(R.id.rectrecycler2);
        populateData();
        initAdapter();
        populateData1();
        initAdapter1();
        populateData2();
        initAdapter2();
        context = Main2Activity.this;
        if (ContextCompat.checkSelfPermission(context, Manifest.permission.CAMERA)
                != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CAMERA}, CAMERAPERMISSIONCODE);

        } else {


        }
        final ImageView scancode= findViewById(R.id.scanqr);
        scancode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                final Animation myAnim = AnimationUtils.loadAnimation( getApplicationContext(),R.anim.bounce);
                MyBounceInterpolator interpolator = new MyBounceInterpolator(0.1, 40);
                myAnim.setInterpolator(interpolator);
                scancode.startAnimation(myAnim);
                 new Handler().postDelayed(new Runnable() {
                     @Override
                     public void run() {
                         Intent i =new Intent(Main2Activity.this,ScanActivity.class);
                         startActivity(i);
                     }
                 },900);



            }
        });
        TextView tx=findViewById(R.id.viewmore);
        tx.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Main2Activity.this,ViewMoreActivity.class);
                startActivity(i);
            }
        });
            
/* ImageView im=findViewById(R.id.scan1);
 im.setOnClickListener(new View.OnClickListener() {
     @Override
     public void onClick(View view) {
         Intent i=new Intent(Main2Activity.this,HistoryProducr.class);
         startActivity(i);
     }
 });*/
        /*for (int i = 0; i < 3; i++) {

            AddRecycler  adapter =new AddRecycler(imageViews,c);
            layoutManager = new LinearLayoutManager(c);
            llmH = new LinearLayoutManager(c);
            llmH.setOrientation(LinearLayoutManager.HORIZONTAL);
            recyclerView.setAdapter(adapter);
            recyclerView.setLayoutManager(llmH);
            recyclerView.setHasFixedSize(true);}
*/
        final FloatingNavigationView floatingNavigationView = findViewById(R.id.floating_navigation_view);
        floatingNavigationView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                floatingNavigationView.open();
            }
        });
        floatingNavigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                int id=menuItem.getItemId();
                if(id==R.id.nav_gallery)
                {
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            Intent i=new Intent(Main2Activity.this,Main3Activity.class);
                            startActivity(i);


                            //the current activity will get finished.
                        }
                    }, 300);

                   /* Intent i =new Intent(Main2Activity.this,HistoryProducr.class);
                    startActivity(i);*/
                    floatingNavigationView.close();
                }
                if(id==R.id.nav_home)
                {
                       floatingNavigationView.close();

                }
                if(id==R.id.nav_tools)
                {
                    floatingNavigationView.close();
                }



                return false;
            }
        });


    }

  /*  private void ScanbarCode() {
        final Activity activity = this;
        IntentIntegrator integrator = new IntentIntegrator(activity);
        integrator.setDesiredBarcodeFormats(IntentIntegrator.QR_CODE);
        integrator.setCameraId(0);
        integrator.setBeepEnabled(true);
        integrator.setBarcodeImageEnabled(false);
        integrator.setPrompt("Scan Qr Code");
        integrator.initiateScan();
    }*/

    private void initAdapter2() {
        recyclerRecentAdapter=new RecyclerRecentAdapter(arrayList2);
        recyclerView2.setAdapter(recyclerRecentAdapter);
        layoutManager = new LinearLayoutManager(getApplicationContext());
        llmH = new LinearLayoutManager(getApplicationContext());
        llmH.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerView2.setLayoutManager(llmH);
        recyclerView2.setHasFixedSize(true);
    }

    private void populateData2() {
        for (int i = 0; i < 3; i++) {
            arrayList2.add("Item " + i);
        }
    }

    private void populateData1() {
        for (int i = 0; i < 3; i++) {
            arrayList1.add("Item " + i);
        }
    }

    private void initAdapter1() {
        recyclerRecentAdapter=new RecyclerRecentAdapter(arrayList1);
        recyclerView1.setAdapter(recyclerRecentAdapter);
        layoutManager = new LinearLayoutManager(getApplicationContext());
        llmH = new LinearLayoutManager(getApplicationContext());
        llmH.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerView1.setLayoutManager(llmH);
        recyclerView1.setHasFixedSize(true);
    }

    private void populateData() {
        for (int i = 0; i < 3; i++) {
            arrayList.add("Item " + i);
        }
    }

    private void initAdapter() {
        recyclerViewAdapter = new RecyclerViewAdapter(arrayList);
        recyclerView.setAdapter(recyclerViewAdapter);
        layoutManager = new LinearLayoutManager(getApplicationContext());
        llmH = new LinearLayoutManager(getApplicationContext());
        llmH.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerView.setLayoutManager(llmH);
        recyclerView.setHasFixedSize(true);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main2, menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }
/*    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (requestCode == CAMERAPERMISSIONCODE) {
            ScanbarCode();
        } else {
            Toast.makeText(context, "We need that for scanning Qr code Plz allow to use your camera!!!", Toast.LENGTH_SHORT).show();
            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    finish();
                }
            }, 2000);
        }

    }*/
 /*   @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
        if (result != null) {
            if (result.getContents() != null) {
                try {




                    Log.d("TAG", "onActivityResult: " + result.getContents());

                    Toast.makeText(this, "" + result.getContents(), Toast.LENGTH_SHORT).show();
                }
                catch (Exception e)
                {
                    Toast.makeText(Main2Activity.this,"wrong text",Toast.LENGTH_SHORT).show();
                }
            }
        } else {
            super.onActivityResult(requestCode, resultCode, data);
            Log.d("TAG", "onActivityResult: " + "Scan Canceled");
        }
    }*/


}
