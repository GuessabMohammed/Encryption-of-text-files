package Main;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Encryption {

	protected static void vigenere(String text, String key) {
		
		int asciiFinal,asciiToAdd;
		String textC="";
		char ch;
		String keyTemp = key;
		while (key.length() < text.length()) {
			key = key + keyTemp;
		}
		for(int i=0;i<text.length();i++) {
			asciiToAdd = (int)(key.charAt(i));
			if  (asciiToAdd >= 97 && asciiToAdd <= 122) {
				asciiToAdd = asciiToAdd-97;
			} else {
				if (asciiToAdd >= 65 && asciiToAdd <= 90) {
					asciiToAdd = asciiToAdd-65;
				}
				else {
					asciiToAdd = 0;
				}
			}
			
			asciiFinal = (int)text.charAt(i);
				if ((asciiFinal+asciiToAdd<123)&&(asciiFinal+asciiToAdd>96)) {
					ch = ((char)(asciiFinal+asciiToAdd));
					textC = textC + ch ;
				}else {
					if ((asciiFinal+asciiToAdd<148)&&(asciiFinal+asciiToAdd>96)) {
						ch = ((char)(asciiFinal+asciiToAdd-26));
						textC = textC + ch ;
						} else {
							if ((asciiFinal+asciiToAdd<90)&&(asciiFinal+asciiToAdd>64)) {
								ch = ((char)(asciiFinal+asciiToAdd));
						    	textC = textC + ch ;
								}else {
									if ((asciiFinal+asciiToAdd<115)&&(asciiFinal+asciiToAdd>64)) {
										ch = ((char)(asciiFinal+asciiToAdd-26));
										textC = textC + ch ;
										}
										else
											textC = textC + text.charAt(i);	
								}
									
						}
							
				}
					
				}
		finalePrud(textC,"Veginere.txt");

	}
	
	protected static void reverce(String t) {
		String reversedText = "";
		char ch;
		int ascii;
		for (int i=0;i<t.length();i++) {
			ascii = (int)(t.charAt(i));
			if  (ascii >= 97 && ascii <= 122) {
				ascii = 122-ascii+97;
				ch = ((char)(ascii));
				reversedText = reversedText + ch ;

			}else {
				
				if (ascii >= 65 && ascii <= 90) {
					ascii = 90-ascii+65;
					ch = ((char)(ascii));
					reversedText = reversedText + ch ;
					
				}else {
					reversedText = reversedText + t.charAt(i);		
				}
			}
		}
		finalePrud(reversedText,"Reverse.txt");
		
	}
	
	protected static  void encrept(String t,int p) {
		String encryptedText = "";
		int ascii;
		char ch;
		p=p%26;
		for (int i=0;i<t.length();i++) {
			ascii = (int)(t.charAt(i));
			if  ((int)(t.charAt(i)) >= 97 && ((int)(t.charAt(i)) <= 122)) {
				if (ascii+p>122) {
					ch = ((char)(ascii+p-26));
					encryptedText = encryptedText + ch ;
					System.out.print(t.charAt(i));
				}else {
					ch = ((char)(ascii+p));
					encryptedText = encryptedText + ch ;
					System.out.print(t.charAt(i));
				}
				
			}
			else {
				
				if ((int)(t.charAt(i)) >= 65 && ((int)(t.charAt(i)) <= 90)) {
					if (ascii+p>90) {
						ch = ((char)(ascii+(p-26)));
						encryptedText = encryptedText + ch ;
						System.out.print(t.charAt(i));
					}else {
						ch = ((char)(ascii+p));
						encryptedText = encryptedText + ch ;
						System.out.print(t.charAt(i));
					}

				} else {
					encryptedText = encryptedText + t.charAt(i);
				}
			}
		}
		finalePrud(encryptedText,"Encrypt.txt");
		
	}
	
	
	private static void finalePrud(String textToAddToFile,String name) {
		try(BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("/home/moh/Desktop/"+name))) {
		   bufferedWriter.write(textToAddToFile);
		} catch (IOException e) {
			System.out.println(e);
		}
		
	}
	
	
	
}
