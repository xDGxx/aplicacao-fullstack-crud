import { useEffect, useState } from 'react';
import './App.css';
import Formulario from './Formulario';
import Tabela from './Tabela';

function App() {

  // Objeto Salao
  const salao = {
    id:0, 
    nomeSalao:'',
    proprietarioSalao:'',
    email:'',
    senha:'',
    ruaSalao:'',
    numeroSalao:'',
    bairroSalao:'',
    cnpj:'',
    telefoneSalao:'',
    seloSalao:''
  }

  //UseState
  const [btnCadastrar, setBtnCadastrar] = useState(true);
  const [saloes, setSaloes] = useState([]);
  const [objSalao, setObjSalao] = useState(salao);

  //UseEffect
  useEffect(()=>{
    fetch("http://localhost:8080/listar")
    .then(retorno => retorno.json())
    .then(retorno_convertido => setSaloes(retorno_convertido));
  }, []);

  //Obtendo os dados do formulário
  const aoDigitar = (e) => {
    setObjSalao({...objSalao, [e.target.name]:e.target.value});
  }

  
  // Cadastrar salao
  const cadastrar = () =>{
    fetch('http://localhost:8080/cadastrar',{
      method:'post',
      body:JSON.stringify(objSalao),
      headers:{
        'Content-type':'application/json',
        'Accept':'application/json'
      }

    })
    .then(retorno => retorno.json())
    .then(retorno_convertido =>{
      
      if( retorno_convertido.mensagem !==undefined){
        alert(retorno_convertido.mensagem);
      }else{
        setSaloes([...saloes, retorno_convertido]);
        alert('Salão cadastrado com sucesso!');
        limparFormulario();
      }
      
    })
    
  }
  // Alterar salao
  const alterar = () =>{
    fetch('http://localhost:8080/alterar',{
      method:'put',
      body:JSON.stringify(objSalao),
      headers:{
        'Content-type':'application/json',
        'Accept':'application/json'
      }

    })
    .then(retorno => retorno.json())
    .then(retorno_convertido =>{
      
      if( retorno_convertido.mensagem !==undefined){
        alert(retorno_convertido.mensagem);
      }else{
        alert('Salão alterado com sucesso!');

        //Cópia do vetor de salões
      let vetorTemp = [...saloes];

      //Índice
      let indice = vetorTemp.findIndex((p) =>{
        return p.id === objSalao.id;
      });

        // Alterar salão do vetorTemp
        vetorTemp[indice] = objSalao

        //Atualizar o vetor de salões
        setSaloes(vetorTemp);
        limparFormulario();
      }

    })

  }
  
  //Remover Salao
  const remover = () =>{
    fetch('http://localhost:8080/remover/'+objSalao.id,{
      method:'delete',
      headers:{
        'Content-type':'application/json',
        'Accept':'application/json'
      }

    })
    .then(retorno => retorno.json())
    .then(retorno_convertido =>{
      
      //Mensagem
      alert(retorno_convertido.mensagem);

      //Cópia do vetor de salões
      let vetorTemp = [...saloes];

      //Índice
      let indice = vetorTemp.findIndex((p) =>{
        return p.id === objSalao.id;
      });

        // Remover salão do vetorTemp
        vetorTemp.splice(indice, 1);

        //Atualizar o vetor de salões
        setSaloes(vetorTemp);

        //Limpar formulario
        limparFormulario();

    })

  }

  //Limpar formulario
  const limparFormulario = () =>{
    setObjSalao(salao);
    setBtnCadastrar(true);
  }

  //Selecionar Salao
  const selecionarSalao = (indice) => {
    setObjSalao(saloes[indice]);
    setBtnCadastrar(false);
  }

  //Retorno
  return (
    <div>
      <Formulario botao={btnCadastrar} eventoTeclado={aoDigitar} cadastrar={cadastrar} obj={objSalao} cancelar={limparFormulario} remover={remover} alterar={alterar} /> 
      <Tabela vetor={saloes} selecionar={selecionarSalao}/>
    </div>
  );
}

export default App;
