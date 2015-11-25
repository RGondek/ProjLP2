package com.br.projetoLp2.business;

import com.br.projetoLp2.model.Pessoa;
import com.br.projetoLp2.model.Profissional;
import com.br.projetoLp2.model.dao.PessoaDAO;
import com.br.projetoLp2.model.dao.ProfissionalDAO;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 1147106
 */
public class ProfissionalManager {

    private static Profissional profissional = null;

    /**
     * @param profissional
     * @return 1 for "Professional inserted" -5 for "Professional not inserted"
     */
    public static int insert(Profissional profissional) {
        ProfissionalDAO dao = new ProfissionalDAO();
        if (dao.insert(profissional)) {
            System.out.println("Manager: Profissional " + profissional.getPessoa().getNome() + " inserido com sucesso.");
            return 1;
        } else {
            System.out.println("Manager: Falha ao inserir profissional.");
            return -5;
        }
    }

    public static List<Profissional> read() {
        ProfissionalDAO dao = new ProfissionalDAO();
        return dao.read();
    }
    
    public static Profissional readById(int id) {
        ProfissionalDAO dao = new ProfissionalDAO();
        return dao.readById(id);
    }
    
    public static Profissional readByIdPessoa(int id) {
        ProfissionalDAO dao = new ProfissionalDAO();
        return dao.readByIdPessoa(id);
    }

    public static int update(int idAntigo, Profissional profissional) {
        ProfissionalDAO proDao = new ProfissionalDAO();
        for (Profissional p : proDao.read()) {
            if (p.getIdProfissional() == idAntigo) {
                int idPessoa = p.getPessoa().getIdPessoa();
                profissional.getPessoa().setIdPessoa(idPessoa);
                profissional.setIdProfissional(idAntigo);
                if (proDao.update(profissional)) {
                    System.out.println("Professional " + profissional.getPessoa().getNome() + " updated successfully");
                    return 1;
                } else {
                    System.out.println("Error: professional not updated");
                    return -5;
                }
            }
        }
        return -5;
    }

    public static boolean delete(int id) {
        ProfissionalDAO dao = new ProfissionalDAO();
        return dao.deleteById(id);
    }
    
    public static Profissional getProfissional() {
        return profissional;
    }

    public static void setProfissional(Profissional profissional) {
        ProfissionalManager.profissional = profissional;
    }

}
