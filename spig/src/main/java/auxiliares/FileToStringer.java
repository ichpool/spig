/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package auxiliares;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author n-droid
 */
public class FileToStringer {

    public String readFile(String fileName) {
        StringBuilder result = new StringBuilder("");

        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource(fileName).getFile());

        try (Scanner scanner = new Scanner(file)) {

        	while (scanner.hasNextLine()) {
        		String line = scanner.nextLine();
        		result.append(line).append("\n");
        	}

        	scanner.close();

        } catch (IOException e) {
        	e.printStackTrace();
        }

        return result.toString();

    }
}
