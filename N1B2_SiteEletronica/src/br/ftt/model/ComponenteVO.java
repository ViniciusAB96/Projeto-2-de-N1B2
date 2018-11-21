package br.ftt.model;

import javafx.scene.control.Alert;

public class ComponenteVO {

    int id;
    String descricao;
    String especificacao;
    int qtde;

    public ComponenteVO() {

    }
    

    public ComponenteVO(int id, String descricao, String especificacao, int qtde) {
		super();
		this.id = id;
		this.descricao = descricao;
		this.especificacao = especificacao;
		this.qtde = qtde;
	}


	public int getId() {
        
        return id;
        
    }//Mudei o retorno do ID para int para que eu possa pegar o valor como inteiro diretamente e assim facilite a vida

    public void setId(String id) {

        try {
            if (VerificadoresRegEx.getMatcherVerificadorIDs(id).matches()) {
                this.id = Integer.parseInt(id);
            } else {
                throw new Exception("O ID do componente informado nao valido !");
            }
        } catch (Exception ex) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("ERRO de cadastro!!!");
            alert.setHeaderText(ex.getMessage());
            alert.setContentText("O ID incorreto !");
            alert.showAndWait();

        }
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        try {
            if (VerificadoresRegEx.getVerificadorDescricaoComponente(descricao).matches()) {
                this.descricao = descricao;
            } else {
                throw new Exception("A descricao do componente não e válido.");
            }
        } catch (Exception ex) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("ERRO de cadastro!!!");
            alert.setHeaderText(ex.getMessage());
            alert.setContentText("A descricao do componente não esta correto, favor verificar esse campo.");
            alert.showAndWait();

        }
    }


	public String getEspecificacao() {
		return especificacao;
	}


	public void setEspecificacao(String especificacao) {
		this.especificacao = especificacao;
	}


	public int getQtde() {
		return qtde;
	}


	public void setQtde(int qtde) {
		this.qtde = qtde;
	}

    
   
}
