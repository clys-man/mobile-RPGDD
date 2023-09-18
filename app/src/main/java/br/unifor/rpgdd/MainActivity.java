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
    public static final String[] OPTIONS = {"Anão", "Elfo", "Humano", "Meio-Gigante"};
    public static final int[] DWARF_IMAGES = {R.drawable.dwarf_1, R.drawable.dwarf_2, R.drawable.dwarf_3, R.drawable.dwarf_4, R.drawable.dwarf_5, R.drawable.dwarf_6, R.drawable.dwarf_7, R.drawable.dwarf_8};
    public static final int[] ELF_IMAGES = {R.drawable.elf_1, R.drawable.elf_2, R.drawable.elf_3, R.drawable.elf_4, R.drawable.elf_5, R.drawable.elf_6, R.drawable.elf_7, R.drawable.elf_8};
    public static final int[] HUMAN_IMAGES = {R.drawable.human_1, R.drawable.human_2, R.drawable.human_3, R.drawable.human_4, R.drawable.human_5, R.drawable.human_6, R.drawable.human_7, R.drawable.human_8};
    public static final int[] HALF_GIANT_IMAGES = {R.drawable.half_giant_1, R.drawable.half_giant_2, R.drawable.half_giant_3, R.drawable.half_giant_4, R.drawable.half_giant_5, R.drawable.half_giant_6, R.drawable.half_giant_7, R.drawable.half_giant_8};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Spinner
        final Spinner combo = findViewById(R.id.comboRaces);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, OPTIONS);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
        combo.setAdapter(adapter);

        combo.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                selected = OPTIONS[i];
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        Button button = findViewById(R.id.generateButton);
        button.setOnClickListener(view -> {
            TextView view1 = findViewById(R.id.name);

            if (view1.getText().toString().isEmpty()) {
                Toast.makeText(MainActivity.this, "Digite um nome", Toast.LENGTH_SHORT).show();
                return;
            }

            if (selected == null) {
                Toast.makeText(MainActivity.this, "Selecione uma raça", Toast.LENGTH_SHORT).show();
                return;
            }

            generateCharacter(view);
        });
    }

    public void generateCharacter(View view) {
        Character character = handleRaceOption();
        handleImage(character);

        TextView view1 = findViewById(R.id.forceTextNumber);
        TextView view2 = findViewById(R.id.dexterityTextNumber);
        TextView view3 = findViewById(R.id.constitutionTextNumber);
        TextView view4 = findViewById(R.id.intelligenceTextNumber);
        TextView view5 = findViewById(R.id.wisdomTextNumber);
        TextView view6 = findViewById(R.id.charismaTextNumber);
        TextView view7 = findViewById(R.id.hpTextNumber);

        view1.setText(String.valueOf(character.getForce()));
        view2.setText(String.valueOf(character.getDexterity()));
        view3.setText(String.valueOf(character.getConstitution()));
        view4.setText(String.valueOf(character.getIntelligence()));
        view5.setText(String.valueOf(character.getWisdom()));
        view6.setText(String.valueOf(character.getCharisma()));
        view7.setText(String.valueOf(character.calculateHp()));
    }

    public Character handleRaceOption() {
        TextView view = findViewById(R.id.name);
        String name = view.getText().toString();
        int force = DiceDraw.draws();
        int dexterity = DiceDraw.draws();
        int constitution = DiceDraw.draws();
        int intelligence = DiceDraw.draws();
        int wisdom = DiceDraw.draws();
        int charisma = DiceDraw.draws();

        switch (this.selected) {
            case "Anão":
                return new Dwarf(name, force, dexterity, constitution, intelligence, wisdom, charisma);
            case "Elfo":
                return new Elf(name, force, dexterity, constitution, intelligence, wisdom, charisma);
            case "Humano":
                return new Human(name, force, dexterity, constitution, intelligence, wisdom, charisma);
            case "Meio-Gigante":
                return new HalfGiant(name, force, dexterity, constitution, intelligence, wisdom, charisma);
            default:
                return null;
        }
    }

    public void handleImage(Character character) {
        ImageView image = findViewById(R.id.imagem);

        switch (this.selected) {
            case "Anão":
                image.setImageResource(DWARF_IMAGES[(int) (Math.random() * DWARF_IMAGES.length)]);
                break;
            case "Elfo":
                image.setImageResource(ELF_IMAGES[(int) (Math.random() * ELF_IMAGES.length)]);
                break;
            case "Humano":
                image.setImageResource(HUMAN_IMAGES[(int) (Math.random() * HUMAN_IMAGES.length)]);
                break;
            case "Meio-Gigante":
                image.setImageResource(HALF_GIANT_IMAGES[(int) (Math.random() * HALF_GIANT_IMAGES.length)]);
                break;
            default:
                break;
        }
    }
}