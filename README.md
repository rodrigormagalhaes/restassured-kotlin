### Automação de testes de api com rest assured e kotlin

- **Pré requisito**
  - > [JDK](https://jdk.java.net/14/) 

- **Executar testes pelo IntelliJ**:
    - Clicar no package `test` com botão direito e `Run All Tests`
    - Após o erro gerado abrir o edit de seleção ao lado do botão `Run` e clicar em `Edit Configurations`
    - Em `VM options` setar o valor **-Dprofile=qa**
    - Clicar em `Run`

- **Executar testes por linha de comando**:
```
./gradlew clean test -Dprofile=qa
```

- **Executar uma única classe de teste por linha de comando**:
```
./gradlew clean test --tests PaymentTest -Dprofile=qa
```


#### Tecnologias

- [Rest Assured](https://rest-assured.io/)
