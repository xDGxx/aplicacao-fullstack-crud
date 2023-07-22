function Tabela({ vetor, selecionar }) {
    return (
        <table className='table'>
            <thead>
                <tr>
                    <th>#</th>
                    <th>Nome do Salão</th>
                    <th>Nome do Proprietário</th>
                    <th>Email do Salão</th>
                    <th>Senha do Salão</th>
                    <th>Rua do Salão</th>
                    <th>Número do Salão</th>
                    <th>Bairro do Salão</th>
                    <th>CNPJ</th>
                    <th>Telefone do Salão</th>
                    <th>Selo do Salão</th>
                    <th>Selecionar</th>
                </tr>
            </thead>

            <tbody>
                {
                    vetor.map((obj, indice) => (
                        <tr key={indice}>
                            <td>{indice+1}</td>
                            <td>{obj.nomeSalao}</td>
                            <td>{obj.proprietarioSalao}</td>
                            <td>{obj.email}</td>
                            <td>{obj.senha}</td>
                            <td>{obj.ruaSalao}</td>
                            <td>{obj.numeroSalao}</td>
                            <td>{obj.bairroSalao}</td>
                            <td>{obj.cnpj}</td>
                            <td>{obj.telefoneSalao}</td>
                            <td>{obj.seloSalao}</td>
                            <td><button onClick={() => {selecionar(indice)}} className="btn btn-success">Selecionar</button></td>
                        </tr>
                    ))
                }
            </tbody>

        </table>
    )
}

export default Tabela;