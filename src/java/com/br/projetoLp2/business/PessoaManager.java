package com.br.projetoLp2.business;

import com.br.projetoLp2.model.Pessoa;
import com.br.projetoLp2.model.dao.PessoaDAO;
import java.util.List;


/**
 *
 * @author 1147106
 */
public class PessoaManager {

    private static Pessoa pessoa = null;
    private static PessoaDAO dao = new PessoaDAO();

    /**
     * @param pessoa
     * @return 1 for "Person inserted" -5 for "Person not inserted"
     */
    public static int insert(Pessoa pessoa) {
        if (dao.insert(pessoa)) {
            System.out.println("Manager: Pessoa " + pessoa.getNome() + " inserida com sucesso.");
            return 1;
        } else {
            System.out.println("Manager: Falha ao inserir pessoa.");
            return -5;
        }
    }

    public static List<Pessoa> read() {
        return dao.read();
    }

    public static Pessoa readById(int id){
        return dao.readById(id);
    }
    
    public static Pessoa readByCpf(String cpf){
        return dao.readByCpf(cpf);
    }
    
    public static boolean update(Pessoa pessoa){
        return dao.update(pessoa);
    }
    
    public static boolean delete(int id){
        return dao.deleteById(id);
    }
    
    public static Pessoa getPessoa() {
        return pessoa;
    }

    public static void setPessoa(Pessoa pessoa) {
        PessoaManager.pessoa = pessoa;
    }


}
