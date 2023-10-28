/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package svotacion;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Bryan Chacach
 */
public class Svotacion {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Scanner entrada = new Scanner(System.in);
        
        Svotacion obj = new Svotacion();
         
          String correoA, contraA;
         
       
        
        int op1, op2, op3, op4,op5, op6, op7, op8;
        
        
        
        System.out.println("SISTEMA DE VOTACION");
        System.out.println("1-Ingresar");
        System.out.println("2-Salir");
        
         System.out.print("Seleccione una opcion: ");
       op1 = scan.nextInt();
       
        switch (op1){
            case 1:
                System.out.print("Ingrese correo electronico: ");
                    correoA = entrada.nextLine();

                    System.out.print("Ingrese contraseña: ");
                    contraA = entrada.nextLine();
                
                if (correoA.equals("jefe@umg.com")&& contraA.equals("algoritmos")) {

                        System.out.print("Bienvenido al sistema\n");
                         System.out.println("""
                                            1-Registro de Usuarios
                                            2-Registro de Votantes
                                            3-Administracion de Elecciones
                                            4-Ingreso al sistema""");
                         System.out.println("Selecciones opcion ");
                        
                         op2 = scan.nextInt();
                         switch (op2){
                             case 1:
                                 System.out.print("Ingrese correo electronico: ");
                    String correoE = scan.next();

                    System.out.print("Ingrese contraseña: ");
                    
                    String psw2 = scan.next();
                     boolean isValido = obj.accesoAlSistema(correoE, psw2);
                     if (isValido) { 
                         
                         
                         do {
                             
                    System.out.println("1-crear Usuarios");
                    System.out.println("2-Modificar Usuarios");
                    System.out.println("3-Reiniciar contraseña");
                    
                    op3= scan.nextInt();
                    
                    
                   
                 
                    switch (op3){
                        
                        
                        
                        case 1:
                             
                          
                              System.out.println("Igrese nombre");
                               String nombre = entrada.nextLine();
                              System.out.println("Ingrese Apellido");
                              String apellido = entrada.nextLine();
                              System.out.println("Ingrese correo");
                              String correo = entrada.nextLine();
                              System.out.println("Ingrese Contraseña");
                              String contra = entrada.nextLine();
                              System.out.println("Ingrese rol");
                              System.out.println("1.Administrador de votaciones,2.Registrador de Votantes");
                              System.out.println("3. Auditor y 4. Votante");
                              op4= scan.nextInt();
                              String rol="";
                              switch (op4){
                                  case 1 -> rol = "Administrador de Votaciones";
                        case 2 -> rol = "Registrador de Votantes";
                        case 3 -> rol = "Auditor";
                        case 4 -> rol = "Votante";
                     
                        default -> System.out.println("Opción de rol no válida.");
                                  
                              
                              
                              }
                              System.out.println("Precione 1 para activar");
                            op5= scan.nextInt();
                            String estado="";
                            switch (op5){
                            case 1 -> estado= "Activo";
                   
                    default -> System.out.println("Opción de rol no válida.");
                            }
                            
                         
                            
                              
                              
            String Usuario = nombre + "|" + apellido + "|" + correo +"|"+contra+ "|"+rol+ "|" +estado+ "\n";
String ruta_usuariosistem = ".\\src\\svotacion\\UsuarioP.txt";
                              
                       try { FileWriter UsuarioP = new FileWriter(ruta_usuariosistem,true);
                        try (BufferedWriter bw = new BufferedWriter(UsuarioP)) {
                            bw.write(Usuario);
                        }
                        
                        
                       } 
                     catch (IOException ex) {
                        Logger.getLogger(Svotacion.class.getName()).log(Level.SEVERE, null, ex);
                    }
                        
                          break;


                      
                     
                        case 2: 
                            System.out.println("Modificar Usuarios");
                            String busqueda = "";
        Scanner busquedas = new Scanner(System.in);
        String ruta_usuariosistem2 = ".\\src\\svotacion\\UsuarioP.txt";
        ArrayList<String> lineasArchivo = new ArrayList<>();

        try {
            FileReader fw = new FileReader(ruta_usuariosistem2);
            BufferedReader br = new BufferedReader(fw);
            String linea;
            while ((linea = br.readLine()) != null) {
                lineasArchivo.add(linea);
            }
            br.close();

            System.out.println("Ingrese correo del usuario a modificar");
            busqueda = busquedas.nextLine();

            boolean usuarioEncontrado = false;

            for (int i = 0; i < lineasArchivo.size(); i++) {
                String[] partes = lineasArchivo.get(i).split("\\|");
                if (partes[2].equals(busqueda)) {
                    System.out.println("Correo localizado");
                    System.out.println("Ingrese los datos a modificar");
                    
                    System.out.println("Ingrese Nombre");
                    partes[0]=busquedas.nextLine();
                    System.out.println("Ingrese apellido ");
                    partes [1] =busquedas.nextLine();
                    System.out.println("Ingrese correo");
                    partes[2] = busquedas.nextLine();
                    System.out.println("ingrese Rol");
                    System.out.println("1.Administrador de votaciones,2.Registrador de Votantes");
                    System.out.println("3. Auditor y 4. Votante");
                    int opcionRol = busquedas.nextInt();
                   
                    switch(opcionRol){
                    case 1 -> rol = "Administrador de Votaciones";
                        case 2 -> rol = "Registrador de Votantes";
                        case 3 -> rol = "Auditor";
                        case 4 -> rol = "Votante";
                     
                        default -> {
                            System.out.println("Opción de rol no válida.");
                            return;
                        }
                    }
                    partes[4] = rol;
                    System.out.println("Ingresa el estado del Usuario");
                    System.out.println("1.Activo, 2. Inactivo");
                    op5= scan.nextInt();
                             estado="";
                            switch (op5){
                            case 1 : estado= "Activo";
                            break;
                            case 2: estado="inactivo";
                   
                            }
                       partes[5] = estado;      
                    lineasArchivo.set(i, String.join("|", partes));
                    System.out.println("Información modificada");
                
                    usuarioEncontrado = true;
                    break;
                }
            }

            if (!usuarioEncontrado) {
                System.out.println("Correo no encontrado");
            }
        } catch (IOException ex) {
            System.out.println("Error: " + ex.getMessage());
        }
        try (FileWriter fw = new FileWriter(ruta_usuariosistem2);
             BufferedWriter bw = new BufferedWriter(fw)) {
            for (String linea : lineasArchivo) {
                bw.write(linea);
                bw.newLine();
        }
        }catch (IOException ex) {
            System.out.println("Error al guardar la información en el archivo: " + ex.getMessage());
                         
                         
                     
                     
                     }
                        case 3:
                          System.out.println("Restablecer Contraseña");
                        String busqueda5 = "";
        Scanner look = new Scanner(System.in);
        String ruta_usuariosistem3 = ".\\src\\svotacion\\UsuarioP.txt";
        ArrayList<String> lineasArchivos = new ArrayList<>();

        try {
            FileReader fw = new FileReader(ruta_usuariosistem3);
            BufferedReader br = new BufferedReader(fw);
            String linea;
            while ((linea = br.readLine()) != null) {
                lineasArchivos.add(linea);
            }
            br.close();

            System.out.println("Ingrese correo del usuario a modificar");
            busqueda5 = look.nextLine();

            boolean usuarioEncontrado = false;

            for (int i = 0; i < lineasArchivos.size(); i++) {
                String[] partes = lineasArchivos.get(i).split("\\|");
                if (partes[2].equals(busqueda5)) {
                    System.out.println("Correo localizado");
                    System.out.println("Ingrese los datos a modificar");
                    
                    System.out.println("Ingrese Contraseña Nueva");
                    partes[3]=look.nextLine();
                    
                    
                    lineasArchivos.set(i, String.join("|", partes));
                    System.out.println("Información modificada");
                
                    usuarioEncontrado = true;
                    break;
                }
            }

            if (!usuarioEncontrado) {
                System.out.println("Correo no encontrado");
            }
        } catch (IOException ex) {
            System.out.println("Error: " + ex.getMessage());
        }
        try (FileWriter fw = new FileWriter(ruta_usuariosistem3);
             BufferedWriter bw = new BufferedWriter(fw)) {
            for (String linea : lineasArchivos) {
                bw.write(linea);
                bw.newLine();
        }
        }catch (IOException ex) {
            System.out.println("Error al guardar la información en el archivo: " + ex.getMessage());
                         
                         
                     
                     
                     }
                            
                           
      
                    }
                    
                    
                         
                         } while (op2 !=4);
                   
                    
                     
                             
                     
                                
    
}
                     case 2:
                         do {
                             String looking, looking2;
        Scanner serch = new Scanner(System.in);
        String ruta2 = ".\\src\\svotacion\\UsuarioP.txt";
        ArrayList<String> lineasArchivo2 = new ArrayList<>();
        
        try {
            FileReader fw2 = new FileReader(ruta2);
            BufferedReader br2 = new BufferedReader(fw2);
            String linea2;
            while ((linea2 = br2.readLine()) != null) {
                lineasArchivo2.add(linea2);
            }
            br2.close();
            System.out.println("Ingrese correo");
                      looking2 = serch.nextLine();
                      System.out.println("Ingrese Contraseña");
                      looking = serch.nextLine();
                    
                      boolean usuarioEncontrados = false;
                      for (int i = 0; i < lineasArchivo2.size(); i++) {
                      String[] partes = lineasArchivo2.get(i).split("\\|");
                     
                      if (partes[2].equals(looking2)&& partes[3].equals(looking)&& partes[4].equals("Registrador de Votantes")&& partes[5].equals("Activo")) {
                       System.out.println("REGISTRO DE VOTATNES");
                              System.out.println("""
                                                 1-Agregar Votante
                                                 2-Modificar Votante
                                                 3-Reiniciar Contrase\u00f1a de Votante
                                                 4-Registrar Fallecimiento de Votante
                                                 5-Atras""");
                         System.out.println("Selecciones opcion ");
                         op6= scan.nextInt();
                         
                         switch (op6){
                             
                             case 1:
                                 
                                 
                                 
                                 
                                 
                                 
                                         int aleatorio = 0;
                                 Random r = new Random();
                                 aleatorio = (int)(r.nextInt()*100);
                              System.out.println("Igrese Nombres Completos");
                              String nombres = entrada.nextLine();
                              System.out.println("Ingrese Apellidos Completos");
                              String apellido = entrada.nextLine();
                              System.out.println("Ingrese Correo");
                              String corr = entrada.nextLine();
                              System.out.println("Ingrese CUI");
                              String cui = entrada.nextLine();
                              System.out.println("""
                                                 seleccione Sexo
                                                  1-Masculino
                                                 2-Femenino""");
                              op7 = scan.nextInt();
                               String sexo="";
                               switch (op7)
                               {
                                   case 1 -> sexo = "M";
                                   case 2 -> sexo = "F";
                               }
                                 System.out.println("Ingre Fecha de nacimiento");
                                 String fechaN = entrada.nextLine();
                                 System.out.println("Ingrese Edad");
                                 Float edad = scan.nextFloat();
                                 if (edad <18){
                                  System.out.println("No se puede Registrar Menores de Edad");
                                 }
                                 else
                                 System.out.println("Ingrese Direccion");
                                 String dire =entrada.nextLine();
                                 System.out.println("Ingrese Departamento");
                                 String dep = entrada.nextLine();
                                 System.out.println("Ingrese Municipio de Residencia");
                                 String muniR = entrada.nextLine();
                                 System.out.println("Ingrese Pais de Residencia");
                                 String pR = entrada.nextLine();
                                 String rolV = "votante";
                                 System.out.println("Su Contraseña es"+ aleatorio);
                                 
       
                              
            String UsuarioVV = nombres + "|" + apellido + "|"+corr+"|" + cui +"|"+sexo+ "|"+fechaN+ "|" +edad+"|"+dire+"|"+dep+"|"+muniR+"|"+pR+"|"+rolV+"|"+aleatorio+"\n";
String ruta_votantes = ".\\src\\svotacion\\UsuarioV.txt";
                              
                       try { FileWriter UsuarioV = new FileWriter(ruta_votantes,true);
                               try (BufferedWriter bw = new BufferedWriter(UsuarioV)) {
                                   bw.write(UsuarioVV);
                               }
                        
                        
                       } 
                     catch (IOException ex) {
                        Logger.getLogger(Svotacion.class.getName()).log(Level.SEVERE, null, ex);
                    }

                           break;      
                             case 2:
                System.out.println("Modificar Votante");               
                            String busqueda0 = "";
        Scanner busquedas2 = new Scanner(System.in);
        String ruta_votantes1 = ".\\src\\svotacion\\UsuarioV.txt";
        ArrayList<String> lineasArchivoz = new ArrayList<>();

        try {
            FileReader fw = new FileReader(ruta_votantes1);
            BufferedReader br = new BufferedReader(fw);
            String linea;
            while ((linea = br.readLine()) != null) {
                lineasArchivoz.add(linea);
            }
            br.close();

            System.out.println("Ingrese correo del usuario a modificar");
            busqueda0 = busquedas2.nextLine();

            boolean usuarioEncontrado = false;

            for (int a = 0; a < lineasArchivoz.size(); a++) {
               partes = lineasArchivoz.get(a).split("\\|");
                if (partes[2].equals(busqueda0)) {
                    System.out.println("Correo localizado");
                    System.out.println("Ingrese los datos a modificar");
                    
                    System.out.println("Ingrese Nombre");
                    partes[0]=busquedas2.nextLine();
                    System.out.println("Ingrese apellido ");
                    partes [1] =busquedas2.nextLine();
                    System.out.println("Ingrese correo");
                    partes[2] = busquedas2.nextLine();                                  
                    System.out.println("Ingrese direccion ");
                    partes[7] = busquedas2.nextLine();
                    System.out.println("Ingrese Departamento");
                    partes[8] = busquedas2.nextLine();
                    System.out.println("Ingrse Municipio");
                    partes[9] = busquedas2.nextLine();
                    System.out.println("Ingrese Pais");
                    partes[10] = busquedas2.nextLine();
                    
                    lineasArchivoz.set(a, String.join("|", partes));
                    System.out.println("Información modificada");
                
                    usuarioEncontrado = true;
                    
                }
            }

            if (!usuarioEncontrado) {
                System.out.println("Correo no encontrado");
            }
        } catch (IOException ex) {
            System.out.println("Error: " + ex.getMessage());
        }
        try (FileWriter fw = new FileWriter(ruta_votantes1);
             BufferedWriter bw = new BufferedWriter(fw)) {
            for (String linea : lineasArchivoz) {
                bw.write(linea);
                bw.newLine();
        }
        }catch (IOException ex) {
            System.out.println("Error al guardar la información en el archivo: " + ex.getMessage());
                     }
        break;
                             case 3:
                                 System.out.println("Reiniciar Contraseña");
                                  System.out.println("Restablecer Contraseña");
                        String busqueda5 = "";
        Scanner look = new Scanner(System.in);
        String ruta_vontantes3 = ".\\src\\svotacion\\UsuarioV.txt";
        ArrayList<String> lineasArchivos = new ArrayList<>();

        try {
            FileReader fw = new FileReader(ruta_vontantes3);
            BufferedReader br = new BufferedReader(fw);
            String linea;
            while ((linea = br.readLine()) != null) {
                lineasArchivos.add(linea);
            }
            br.close();

            System.out.println("Ingrese correo del usuario a modificar");
            busqueda5 = look.nextLine();

            boolean usuarioEncontrado = false;

            for (int b = 0; b < lineasArchivos.size(); b++) {
                 partes = lineasArchivos.get(b).split("\\|");
                if (partes[2].equals(busqueda5)) {
                    System.out.println("Correo localizado");
                    System.out.println("Ingrese los datos a modificar");
                    
                    System.out.println("Ingrese Contraseña Nueva");
                    partes[12]=look.nextLine();
                    
                    
                    lineasArchivos.set(i, String.join("|", partes));
                    System.out.println("Información modificada");
                
                    usuarioEncontrado = true;
                    break;
                }
            }

            if (!usuarioEncontrado) {
                System.out.println("Correo no encontrado");
            }
        } catch (IOException ex) {
            System.out.println("Error: " + ex.getMessage());
        }
        try (FileWriter fw = new FileWriter(ruta_vontantes3);
             BufferedWriter bw = new BufferedWriter(fw)) {
            for (String linea : lineasArchivos) {
                bw.write(linea);
                bw.newLine();
        }
        }catch (IOException ex) {
            System.out.println("Error al guardar la información en el archivo: " + ex.getMessage());
                         
                         
                     
                     
                     }
                             case 4:
                                 System.out.println("Registro de fallecimineto");
                             case 5:
                         }   
                          
                          
                      
                    lineasArchivo2.set(i, String.join("|", partes));
                          
                
                    usuarioEncontrados = true;
                    break;
        
        }
                      
                      }if (!usuarioEncontrados) {
                System.out.println("codigo no encontrado");
            }
        } catch (IOException ex) {
            System.out.println("Error: " + ex.getMessage());
        }
        try (FileWriter fw2 = new FileWriter(ruta2);
             BufferedWriter bw = new BufferedWriter(fw2)) {
            for (String linea : lineasArchivo2) {
                bw.write(linea);
                bw.newLine();
        }
        }catch (IOException ex) {
            System.out.println("Error al guardar la información en el archivo: " + ex.getMessage());
                         
                         
                     
                     
                     }
                             
                             
                             
                             
                             
                          
                         } while (op2 !=4);
                         
                     case 3:
                         do {
                             
                                  System.out.println("Administracion de elecciones");
                         
                         System.out.println("""
                                            1-Gestionar Elcciones
                                             2-Gestionar Candidatos
                                            3-Configurar Elcciones""");
                         System.out.println("Selecciones opcion ");
                         op8= scan.nextInt();
                         switch (op8){
                             case 1:
                             
                                 
                                 System.out.println("Gestionar Elecciones");
                             case 2:
                                 System.out.println("Gestionar Candidatos");
                                 System.out.println("""
                                                    1-Agregar Candidato
                                                    2-Modificar Informacion
                                                    3-Eliminar Candidato
                                                    """);
                                 System.out.println("Selecciones Opcion");
                                  op8= scan.nextInt();
                                  switch (op8){
                                      
                                      
                                      case 1: 
                                              int aleatorio = 0;
                                 Random r = new Random();
                                 aleatorio = (int)(r.nextDouble()*10000);
                                          
                                          System.out.println("Agregar Candidato");
                                          System.out.println("Igrese nombre");
                               String nombre = entrada.nextLine();
                              System.out.println("Ingrese Apellido");
                              String apellido = entrada.nextLine();
                                          System.out.println("Ingrese Informacion Academica");
                                          String infoA = entrada.nextLine();
                                          System.out.println("Informacion Profesioanl");
                                          String infoP = entrada.nextLine();
                                          System.out.println("Nomre del Partido que respresenta");
                                          String partidoR = entrada.nextLine();   
                                          System.out.println("Su Codigo es: "+ aleatorio);
                             
                             
                         
                            
                              
                              
            String UsuarioC = nombre + "|" + apellido + "|" + infoA +"|"+infoP+ "|"+partidoR + "|" +aleatorio+ "\n";
String ruta_usuariosistem = ".\\src\\svotacion\\candidatos.txt";
                              
                       try { FileWriter UsuarioP = new FileWriter(ruta_usuariosistem,true);
                        try (BufferedWriter bw = new BufferedWriter(UsuarioP)) {
                            bw.write(UsuarioC);
                        }
                        
                        
                       } 
                     catch (IOException ex) {
                        Logger.getLogger(Svotacion.class.getName()).log(Level.SEVERE, null, ex);
                    }
                                          
                                          
                                      case 2:
                                          System.out.println("Modificar Informacion");
                                          
                            String busqueda = "";
        Scanner busquedas = new Scanner(System.in);
        String ruta_usuariosistem2 = ".\\src\\svotacion\\candidatos.txt";
        ArrayList<String> lineasArchivo = new ArrayList<>();

        try {
            FileReader fw = new FileReader(ruta_usuariosistem2);
            BufferedReader br = new BufferedReader(fw);
            String linea;
            while ((linea = br.readLine()) != null) {
                lineasArchivo.add(linea);
            }
            br.close();

            System.out.println("Ingrese codigo");
            busqueda = busquedas.nextLine();

            boolean usuarioEncontrado = false;

            for (int i = 0; i < lineasArchivo.size(); i++) {
                String[] partes = lineasArchivo.get(i).split("\\|");
                if (partes[5].equals(busqueda)) {
                    System.out.println("codigo localizado");
                    System.out.println("Ingrese los datos a modificar");
                    
                    System.out.println("Ingrese Nombre");
                    partes[0]=busquedas.nextLine();
                    System.out.println("Ingrese apellido ");
                    partes [1] =busquedas.nextLine();
                    System.out.println("Ingrese Informacion Academica");
                    partes [2] =busquedas.nextLine();
                    System.out.println("Ingrese Informacion Profesional");
                    partes [3] =busquedas.nextLine();
                    System.out.println("Ingrese Nombre De Su Partido");
                    partes [4] =busquedas.nextLine();
                
                    
                  
                    
                    lineasArchivo.set(i, String.join("|", partes));
                    System.out.println("Información modificada");
                
                    usuarioEncontrado = true;
                    break;
                }
            }

            if (!usuarioEncontrado) {
                System.out.println("codigo no encontrado");
            }
        } catch (IOException ex) {
            System.out.println("Error: " + ex.getMessage());
        }
        try (FileWriter fw = new FileWriter(ruta_usuariosistem2);
             BufferedWriter bw = new BufferedWriter(fw)) {
            for (String linea : lineasArchivo) {
                bw.write(linea);
                bw.newLine();
        }
        }catch (IOException ex) {
            System.out.println("Error al guardar la información en el archivo: " + ex.getMessage());
                         
                         
                     
                     
                     }
                                          
                                      case 3:
                                          System.out.println("Eliminar Candidato");
                                        
        
                                  }
                             case 3:
                                 System.out.println("Configuracion de candidatos");
                         
                         }
                         
                         }while (op2 !=4);
                    
                     case 4:
                         
                  do {
                      System.out.println("Ingreso al sistema");
                                          String looking, looking2;
        Scanner serch = new Scanner(System.in);
        String ruta4 = ".\\src\\svotacion\\UsuarioV.txt";
        ArrayList<String> lineasArchivo = new ArrayList<>();
        
        try {
            FileReader fw = new FileReader(ruta4);
            BufferedReader br = new BufferedReader(fw);
            String linea;
            while ((linea = br.readLine()) != null) {
                lineasArchivo.add(linea);
            }
            br.close();
            System.out.println("Ingrese correo");
                      looking2 = serch.nextLine();
                      System.out.println("Ingrese Contraseña");
                      looking = serch.nextLine();
                    
                      boolean usuarioEncontrado = false;
                      for (int i = 0; i < lineasArchivo.size(); i++) {
                      String[] partes = lineasArchivo.get(i).split("\\|");
                     
                      if (partes[2].equals(looking2)&& partes[12].equals(looking)&& partes[11].equals("votante")) {
                          System.out.println("Puede Votar");
                          System.out.println("""
                                             1-Votar para Presidente
                                             2-votar para Alcalde
                                             """);
                          
                          
                      
                    lineasArchivo.set(i, String.join("|", partes));
                          
                
                    usuarioEncontrado = true;
                    break;
        
        }
                      
                      }if (!usuarioEncontrado) {
                System.out.println("Usuario no encontrado");
            }
        } catch (IOException ex) {
            System.out.println("Error: " + ex.getMessage());
        }
        
                      

        
                    
                  }while (op2 !=4);
                                         
                                 
                                 }
                             
                             
                                         
                                 
                                 
                   
                             
                                
                         
                         
        
        
        } else {
                    System.out.println("Error");
                }
                     }
      
    }   

    
    boolean accesoAlSistema (String correo, String contrasenia) {
        

        boolean accesoValido = false;
        
        if (correo.compareTo("admin@umg.com") == 0) {
            if (contrasenia.compareTo("ingreso123") == 0) {
              
                accesoValido = true;
            }
            else {
                System.err.println("Contraseña incorrecta.");
                accesoValido = false;
            }
        }
        else {
            System.err.println("Usuario incorrecto.");
            accesoValido = false;
        } 
        
        return accesoValido;
    }
    
}

