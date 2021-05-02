# DESAFIO B2W USANDO API STAR WARS 

## Índice

<ol>
  <li><a href="#projeto">Solução</a></li>
  <li><a href="#teste">Testes</a></li>
  <li><a href="#funcionalidades">Funcionalidades</a>
    <ol>
      <li><a href="#create">Inserir um Planeta</a></li>
      <li><a href="#findAll">Listar todos os Planetas</a></li>
      <li><a href="#findByName">Buscar por Nome</a></li>
      <li><a href="#findById">Buscar por Id</a></li>
      <li><a href="#delete">Deletar um Planeta</a></li>
    </ol>
    <li><a href="#swagger">Swagger</a>
    <li><a href="#schedule">Agendamento</a>
  </li>
 
</ol>

<a name="projeto">1. O Projeto</a> 

* O objetivo deste projeto é criar um serviço REST para ser utilizade em um jogo que irá realizar atividades com o objeto Planeta, que tema os seguintes atributos: Nome, Clima e Terreno. Também foi solicitado que ao adicionar um planeta fosse obtido a quantidade de filmes em que eles aperecem, que podem ser obtidas pela API pública do Star Wars.

<a name="teste">1. Testes</a> 

* Para realizar os testes basta ir para src/test/Java e executar os testes unitários com JUnit.

<a name="funcionalidades">1. Funcionalidades</a> 

* Os próximos links são para descrever as funcionalidades do sistema.

<a name="create">1. Inserir um Planeta</a> 

* Para inserir um planeta, é necessário realizar um request com o método POST para o endpoint "/planets".

&nbsp;&nbsp;&nbsp;&nbsp; Exemplo: http://localhost:8080/planets
```JSON
{
   "name": "Tatooine",
   "climate": "Cold",
   "terrain": "desert"
}
```

<a name="findAll">2. Listar todos os Planetas</a> 

* Para listar todos os Planetas cadastrados, é necessário realizar um request com o método GET para o endpoint "/planets".

&nbsp;&nbsp;&nbsp;&nbsp; Exemplo: http://localhost:8080/planets

```JSON
{
   "name": "Tatooine",
   "climate": "Cold",
   "terrain": "desert",
   "countFilms": 2
},
{
   "name": "Alderaan",
   "climate": "tropical",
   "terrain": "jungle",
   "countFilms": 3
}
```

<a name="findByName">3. Buscar por Nome</a> 

* Para buscar um Planeta por nome, é necessário realizar um request com o método GET para o endpoint "/planets/name?name=".

&nbsp;&nbsp;&nbsp;&nbsp; Exemplo: http://localhost:8080/planets/name?name=Tatooine

<a name="findById">4. Buscar por Id</a> 

* Para buscar um Planeta por ID, é necessário realizar um request com o método GET para o endpoint "/planets/id?id=".

&nbsp;&nbsp;&nbsp;&nbsp; Exemplo: http://localhost:8080/planets/id?id=608cd7dd60bebb592bb36747

<a name="delete">5. Deletar um Planeta</a> 

* Para deletar um Planeta por ID, é necessário realizar um request com o método DELETE para o endpoint "/planets?id=".

&nbsp;&nbsp;&nbsp;&nbsp; Exemplo: http://localhost:8080/planets?id=608cd7dd60bebb592bb36747


<a name="swagger">6. Swagger</a> 

* A aplicação também contém um Swagger com a documentação de todos os endpoints e seus exemplos, para isso é necessário fazer um request com método GET para a seguinte url: http://localhost:8080/swagger-ui.html



<a name="schedule">7. Agendamento</a> 

* A aplicação tem um agendamento para fazer requests na api do Star Wars a cada 6 horas, no caso de alguma alteração nos dados.