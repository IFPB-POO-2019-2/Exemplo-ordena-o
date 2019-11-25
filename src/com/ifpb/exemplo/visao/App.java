package com.ifpb.exemplo.visao;

import com.ifpb.exemplo.modelo.Pessoa;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Comparator;

public class App {

    public static void main(String[] args) {

        Pessoa[] pessoas = {
                new Pessoa("111.111.111-01", "João",
                        LocalDate.of(1990,1,2)),
                new Pessoa("222.222.222-02", "Maria",
                        LocalDate.of(1989,5,1)),
                new Pessoa("333.333.333-03", "Ana",
                        LocalDate.of(1992,5,1))
        };

        System.out.println("Imprimir inverso");
        imprimirInverso(pessoas);
        System.out.println("Imprimir maior");
        System.out.println(maior(pessoas));

//        Comparador comparador = new Comparador();
//        Arrays.sort(pessoas, comparador);
//        System.out.println(Arrays.toString(pessoas));

        //Class interna anônima
        Comparator<Pessoa> comparador = new Comparator<Pessoa>() {
            @Override
            public int compare(Pessoa o1, Pessoa o2) {
                return o1.getNome().compareTo(o2.getNome());
            }
        };

        Arrays.sort(pessoas, comparador);
        System.out.println("Imprimir ordenado");
        System.out.println(Arrays.toString(pessoas));

    }

    //Exercício 1
    public static <T> void imprimirInverso(T[] array){
        for(int i=array.length-1; i>=0; i--){
            System.out.println(array[i]);
        }
    }

    //Exercício 2
    public static <T extends Comparable> T maior(T[] array){
        T maior = array[0];
        for(T elemento : array){
            if(elemento.compareTo(maior)>0) maior = elemento;
        }
        return maior;
    }

    //Classe interna
    private static class Comparador implements Comparator<Pessoa>{
        @Override
        public int compare(Pessoa o1, Pessoa o2) {
            return o1.getNome().compareTo(o2.getNome());
        }
    }


}
