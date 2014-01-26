package br.com.ehrickwilliam.bibliotecas;

import java.awt.Component;
import java.awt.Image;
import static java.lang.Thread.sleep;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author ehrickwilliam
 */
public class Util {

    private static SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
    private static Component rootPane;

    /**
     * Metodo utilitario que abre um formulario posicionado no centro da tela.
     *
     * @param dialog Objeto de formulario JDialog a abrir centralizado.
     */
    public static void abrirDialogCentralizadoForm(JFrame dialog) {

        dialog.setLocationRelativeTo(null);
        dialog.setVisible(true);
    }

    public static void abrirDialogCentralizado(JDialog dialog) {

        dialog.setLocationRelativeTo(null);
        dialog.setVisible(true);
    }

    /**
     * Mostra seletor de arquivo com filtro para imagem e devolve objeto
     * ImageIcon com imagem redimensionada para o tamanho informado.
     *
     * @param larguraParaImagem Largura para a imagem devolvida.
     * @param alturaParaImagem Altura para a imagem devolvida.
     * @return ImageIcon com a imagem redimensionada.
     */
    public static ImageIcon selecionarIconeParaLabel(int larguraParaImagem, int alturaParaImagem) {
        // abre seletor de arquivo
        JFileChooser chooser = new JFileChooser();
        chooser.showOpenDialog(null);

        // somente queremos selecionar arquivos, mas nao pastas
        chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);

        // filtra para somente arquivos de imagem
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Arquivos de imagens",
                "png", "jpeg", "jpg", "bmp", "gif");
        chooser.addChoosableFileFilter(filter);
        chooser.setAcceptAllFileFilterUsed(true);

        // se houve arquivo valido selecionado
        if (chooser.getSelectedFile() != null) {
            // carrega arquivo de imagem
            ImageIcon icon = new ImageIcon(chooser.getSelectedFile().getAbsolutePath());
            // redimensiona para o tamanho do JLabelFoto
            icon.setImage(icon.getImage().getScaledInstance(
                    larguraParaImagem, alturaParaImagem, Image.SCALE_SMOOTH));
            // colocar imagem icone no label de exibicao no formulario
            return icon;
        }
        return null;
    }

    /**
     * Captura a data e hora do sistema. A hora da maquina.
     *
     * @return A string contendo a data e hora.
     */
    public static String getDateTime() {
        DateFormat format = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date date = new Date();
        return format.format(date);
    }

    /**
     * Inicia uma thread com função de atualizar o relogio do sistema.
     *
     * @param label O label que vai receber a hora.
     */
    public static void iniciarRelogio(final JLabel label) {
        new Thread() {
            @Override
            public void run() {
                while (true) {
                    label.setText(Util.getDateTime());

                    DateFormat format = new SimpleDateFormat("HH:mm:ss");
                    Date dateBackUp = new Date();

                    try {
                        sleep(1000);
                    } catch (Exception e) {
                        System.out.println(e);
                    }
                }
            }
        }.start();
    }

    public static Calendar stringToCalendar(String data) {
        try {
            Calendar c = Calendar.getInstance();
            c.setTime(dateFormat.parse(data));
            return c;
        } catch (ParseException ex) {
            Logger.getLogger(Util.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public static String calendarToString(Calendar cal) {
        return dateFormat.format(cal.getTime());
    }

    public static boolean mostraMensagemEmTela(String text) {
        int opcao = JOptionPane.showConfirmDialog(rootPane,
                text, "Confirmação",
                JOptionPane.YES_NO_OPTION);
        if (opcao != JOptionPane.YES_OPTION) {
            return false;
        }
        return true;
    }

    public static double calculaVolume(double al, double co, double la) {
        return al * co * la;
    }

    public static boolean validacpf(String strCpf) { // formato XXX.XXX.XXX-XX   
        if (!strCpf.substring(0, 1).equals("")) {
            try {
                int d1, d2;
                int digito1, digito2, resto;
                int digitoCPF;
                String nDigResult;
                strCpf = strCpf.replace('.', ' ');
                strCpf = strCpf.replace('-', ' ');
                strCpf = strCpf.replaceAll(" ", "");
                d1 = d2 = 0;
                digito1 = digito2 = resto = 0;

                for (int nCount = 1; nCount < strCpf.length() - 1; nCount++) {
                    digitoCPF = Integer.valueOf(strCpf.substring(nCount - 1, nCount)).intValue();

                    //multiplique a ultima casa por 2 a seguinte por 3 a seguinte por 4 e assim por diante.   
                    d1 = d1 + (11 - nCount) * digitoCPF;

                    //para o segundo digito repita o procedimento incluindo o primeiro digito calculado no passo anterior.   
                    d2 = d2 + (12 - nCount) * digitoCPF;
                }

                //Primeiro resto da divisão por 11.   
                resto = (d1 % 11);

                //Se o resultado for 0 ou 1 o digito é 0 caso contrário o digito é 11 menos o resultado anterior.   
                if (resto < 2) {
                    digito1 = 0;
                } else {
                    digito1 = 11 - resto;
                }

                d2 += 2 * digito1;

                //Segundo resto da divisão por 11.   
                resto = (d2 % 11);

                //Se o resultado for 0 ou 1 o digito é 0 caso contrário o digito é 11 menos o resultado anterior.   
                if (resto < 2) {
                    digito2 = 0;
                } else {
                    digito2 = 11 - resto;
                }

                //Digito verificador do CPF que está sendo validado.   
                String nDigVerific = strCpf.substring(strCpf.length() - 2, strCpf.length());

                //Concatenando o primeiro resto com o segundo.   
                nDigResult = String.valueOf(digito1) + String.valueOf(digito2);

                //comparar o digito verificador do cpf com o primeiro resto + o segundo resto.   
                return nDigVerific.equals(nDigResult);
            } catch (Exception e) {
                System.err.println("Erro !" + e);
                return false;
            }
        } else {
            return false;
        }
    }

    public static boolean validaCnpj(String str_cnpj) {
        if (!str_cnpj.substring(0, 1).equals("")) {
            try {
                str_cnpj = str_cnpj.replace('.', ' ');
                str_cnpj = str_cnpj.replace('/', ' ');
                str_cnpj = str_cnpj.replace('-', ' ');
                str_cnpj = str_cnpj.replaceAll(" ", "");
                int soma = 0, dig;
                String cnpj_calc = str_cnpj.substring(0, 12);

                if (str_cnpj.length() != 14) {
                    return false;
                }
                char[] chr_cnpj = str_cnpj.toCharArray();
                /* Primeira parte */
                for (int i = 0; i < 4; i++) {
                    if (chr_cnpj[i] - 48 >= 0 && chr_cnpj[i] - 48 <= 9) {
                        soma += (chr_cnpj[i] - 48) * (6 - (i + 1));
                    }
                }
                for (int i = 0; i < 8; i++) {
                    if (chr_cnpj[i + 4] - 48 >= 0 && chr_cnpj[i + 4] - 48 <= 9) {
                        soma += (chr_cnpj[i + 4] - 48) * (10 - (i + 1));
                    }
                }
                dig = 11 - (soma % 11);
                cnpj_calc += (dig == 10 || dig == 11)
                        ? "0" : Integer.toString(dig);
                /* Segunda parte */
                soma = 0;
                for (int i = 0; i < 5; i++) {
                    if (chr_cnpj[i] - 48 >= 0 && chr_cnpj[i] - 48 <= 9) {
                        soma += (chr_cnpj[i] - 48) * (7 - (i + 1));
                    }
                }
                for (int i = 0; i < 8; i++) {
                    if (chr_cnpj[i + 5] - 48 >= 0 && chr_cnpj[i + 5] - 48 <= 9) {
                        soma += (chr_cnpj[i + 5] - 48) * (10 - (i + 1));
                    }
                }
                dig = 11 - (soma % 11);
                cnpj_calc += (dig == 10 || dig == 11)
                        ? "0" : Integer.toString(dig);
                return str_cnpj.equals(cnpj_calc);
            } catch (Exception e) {
                System.err.println("Erro !" + e);
                return false;
            }
        } else {
            return false;
        }

    }

    public static String md5(String senha) {
        String sen = "";
        MessageDigest md = null;
        try {
            md = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        BigInteger hash = new BigInteger(1, md.digest(senha.getBytes()));
        sen = hash.toString(16);
        return sen;
    }

    public static Calendar DateToCalendar(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return cal;
    }
}
