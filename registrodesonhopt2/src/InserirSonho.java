import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.Scanner;

public class InserirSonho {
    public static void inserirSonho(String arquivoCSV) throws IOException {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Digite a data em que você sonhou isso: ");
            String data = scanner.nextLine();

            System.out.print("Qual o tema do seu sonho? (ex: repetido, pesadelo, lembranças, aleatório, feliz). ");
            String tema = scanner.nextLine();

            System.out.print("Descreva exatamente o que você lembra desse sonho: ");
            String descricao = scanner.nextLine();

            System.out.print("Digite a hora e/ou turno (manhã, tarde, noite) em que você sonhou: ");
            String turno = scanner.nextLine();

            System.out.print("Descreva brevemente as emoções sentidas durante seu sonho. (ex: felicidade, tristeza, medo, raiva, nojo, surpresa) ");
            String emocoes = scanner.nextLine();

            // Abra o arquivo CSV para escrita, mas não dentro do try-with-resources
            FileWriter writer = new FileWriter(arquivoCSV, true);
            BufferedWriter bufferedWriter = new BufferedWriter(writer);

            bufferedWriter.write("Data: " + data + "\n");
            bufferedWriter.write("Tema: " + tema + "\n");
            bufferedWriter.write("Descrição: " + descricao + "\n");
            bufferedWriter.write("Hora: " + turno + "\n");
            bufferedWriter.write("Emoções: " + emocoes + "\n");
            bufferedWriter.write("\n");
            System.out.println("Sonho inserido com sucesso e salvo no arquivo!");

            // Feche o BufferedWriter e o FileWriter
            bufferedWriter.close();
            writer.close();
        }
    }
}