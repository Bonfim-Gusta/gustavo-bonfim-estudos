package com.atividadesPB.api_rest_semana07.staticClasses;

public class ValidacaoPessoa {

    public static String mensagem(boolean isMaiorIdade){
        if (isMaiorIdade){
            return "Entry Allowed";
        }
        else {
            return "Entry Denied";
        }
    }

    public static boolean verificarMaiorIdade(Integer idade){
        return idade >= 18;
    }
}
