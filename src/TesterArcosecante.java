
import java.awt.*;
import javax.swing.*;

public class TesterArcosecante {

    static int larghezza = 1000, altezza = 800;         // grandezza del Jframe

    public static void main(String[] args){
        JFrame f = new JFrame("Grafico arcosecante");
        PianoCartesiano p = new PianoCartesiano(larghezza, altezza);
        f.add(p);
        f.setBounds(80, 80, larghezza + 100, altezza + 100);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
    }
}
//.....................................................................................


class PianoCartesiano extends JPanel {

    private int width;
    private int height;

    public PianoCartesiano(int larghezza, int altezza) {
        this.width = larghezza;
        this.height = altezza;
        setBackground(Color.WHITE);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.setColor(Color.gray);

        for(int i = 0; i < 17; i++){
            g.drawLine(0, (int) (((height * 0.2)/3.2) * i), width, (int) (((height * 0.2)/3.2) * i));
            JLabel etichetta = new JLabel();
            etichetta.setText(String.valueOf( Math.round((3.2 - 0.2 * i) * 10.0) / 10.0)); // * 10.0 w / 10.0 servono per arrotondare a una cifra decimale
            etichetta.setBounds(width + 10, (int) (((height * 0.2) / 3.2) * i) - 5, 20, 20);
            etichetta.setVisible(true);
            this.add(etichetta);
        }

        for(int i = 0; i < 11; i++){
            g.drawLine((((width * 2)/20) * i), 0 , (((width * 2)/20) * i), height);
            JLabel etichetta = new JLabel();
            etichetta.setText(String.valueOf(2 * i - 10));
            etichetta.setBounds((((width * 2)/20) * i), height + 10, 20, 20);
            etichetta.setVisible(true);
            this.add(etichetta);
        }


        g.setColor(Color.red);

        for(double i = 0; i < 20; i += 0.00001){
            double xTeorica = i - 10;
            if(xTeorica > -1 && xTeorica < 1) continue;
            double yTeorica = (Math.PI / 2) - Math.sin(1 / (xTeorica));

            int xGrafico = (int) ((width * i) / 20);
            int yGrafico = (int) ((height * yTeorica) / 3.2);

            g.drawLine(xGrafico, height - yGrafico, xGrafico, height - yGrafico);
        }
    }
}