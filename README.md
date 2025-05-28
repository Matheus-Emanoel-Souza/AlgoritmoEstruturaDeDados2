📝 Proposta:        
Este projeto consiste na implementação de uma Web API em Java para cadastro de alunos, disciplinas e cursos, além do cálculo dos resultados dos alunos nas disciplinas.        

O sistema realiza:        
✔️ CRUD de Alunos, Disciplinas e Cursos.        
✔️ Consulta de resultados por aluno ou por disciplina.        
✔️ Cálculo de aprovação ou reprovação com base na média e nota mínima da disciplina.        

Regras e requisitos:        
Dados armazenados em listas duplamente encadeadas com cabeçalhos (nada de listas prontas da linguagem — quem usar, leva zero 😅).
Leitura inicial dos dados a partir de arquivos texto (Alunos.txt, Disciplinas.txt e Cursos.txt) no padrão dado1;dado2;dado3.
Informações podem ser cadastradas tanto via arquivo quanto pela interface web.
Ao encerrar, o sistema salva todos os dados novamente nos arquivos.
Mais detalhes em : [AED II - Especificação do Trabalho N2 .pdf](https://github.com/user-attachments/files/20473606/AED.II.-.Especificacao.do.Trabalho.N2.pdf)        
        
🔧 Tecnologias Utilizadas        
☕ Java 23 — Linguagem de programação principal
🐱‍💻 IDE Eclipse for enterprise and web developers 2023-03 — Ambiente de desenvolvimento.        
🐱‍🏍 Apache Tomcat 11.0 — Servidor web para deploy da aplicação.        
🔄 Listas Duplamente Encadeadas com Cabeçalho e Cauda — Implementadas manualmente para manipulação dos dados (sem uso de estruturas nativas).                

🖥️ Como rodar na sua máquina?        
✅ Passo 1 — Clone o repositório            
git clone https://github.com/seu-usuario/seu-repositorio.git        
✅ Passo 2 — Baixe o Tomcat 11        
🔗 [Download do Apache Tomcat 11](https://dlcdn.apache.org/tomcat/tomcat-11/v11.0.7/bin/apache-tomcat-11.0.7.zip)        
Descompacte o arquivo em uma pasta fácil de acessar, tipo C:\tomcat-11 ou onde preferir.        
✅ Passo 3 — Configure o Tomcat no Eclipse        
No Eclipse, vá até a aba “Servers” (se não aparecer, ative em Window > Show View > Servers).        
Clique em “No servers are available. Click this link to create a new server...”        
Selecione:        
Apache > Tomcat v11.0 Server                
Clique em Next        
No campo Tomcat installation directory, selecione a pasta onde você descompactou o Tomcat.        
Clique em Finish.        
        
Agora, clique com o botão direito no servidor que apareceu na aba Servers, vá em Add and Remove...        
        
Adicione seu projeto na lista da direita (Configured) e clique em Finish.

Clique com o botão direito no servidor e selecione Start.
