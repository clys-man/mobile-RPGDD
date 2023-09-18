package br.unifor.rpgdd;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import br.unifor.rpgdd.game.dice.DiceDraw;
import br.unifor.rpgdd.game.race.Dwarf;
import br.unifor.rpgdd.game.race.Elf;
import br.unifor.rpgdd.game.race.HalfGiant;
import br.unifor.rpgdd.game.race.Human;
import br.unifor.rpgdd.game.race.Character;

public class MainActivity extends AppCompatActivity {
    private String  selected;
    public static final String[] OPTIONS = {"Anão", "Elfo", "Humano2", "Meio-Gigante"};
    public static final int[] IMAGES = {R.drawable.anao, R.drawable.elfo, R.drawable.humano, R.drawable.gigante};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView imagem = (ImageView) findViewById(R.id.imagem);


        //Spinner
        final Spinner combo = findViewById(R.id.comboRaces);
        ArrayAdapter<String> adaptador = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, OPTIONS);
        adaptador.setDropDownViewResource(android.R.layout.simple_spinner_item);
        combo.setAdapter(adaptador);

        combo.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                imagem.setImageResource(IMAGES[i]);
                selected = OPTIONS[i];
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        Button button = findViewById(R.id.generateButton);
        button.setOnClickListener(view -> generateCharacter(view));
    }

    public void generateCharacter(View view) {
        Toast.makeText(this, "Gerando personagem...", Toast.LENGTH_SHORT).show();
        Character character = handleRaceOption(selected);

        TextView view1 = findViewById(R.id.forceTextNumber);
        TextView view2 = findViewById(R.id.dexterityTextNumber);
        TextView view3 = findViewById(R.id.constitutionTextNumber);
        TextView view4 = findViewById(R.id.intelligenceTextNumber);
        TextView view5 = findViewById(R.id.wisdomTextNumber);
        TextView view6 = findViewById(R.id.charismaTextNumber);

        view1.setText(String.valueOf(character.getForce()));
        view2.setText(String.valueOf(character.getDexterity()));
        view3.setText(String.valueOf(character.getConstitution()));
        view4.setText(String.valueOf(character.getIntelligence()));
        view5.setText(String.valueOf(character.getWisdom()));
        view6.setText(String.valueOf(character.getCharisma()));
    }

    public Character handleRaceOption(String selected) {
        int force = DiceDraw.draws();
        int dexterity = DiceDraw.draws();
        int constitution = DiceDraw.draws();
        int intelligence = DiceDraw.draws();
        int wisdom = DiceDraw.draws();
        int charisma = DiceDraw.draws();

        switch (selected) {
            case "Anão":
                return new Dwarf(force, dexterity, constitution, intelligence, wisdom, charisma);
            case "Elfo":
                return new Elf(force, dexterity, constitution, intelligence, wisdom, charisma);
            case "Humano":
                return new Human(force, dexterity, constitution, intelligence, wisdom, charisma);
            case "Meio-Gigante":
                return new HalfGiant(force, dexterity, constitution, intelligence, wisdom, charisma);
            default:
                return null;
        }
    }
}