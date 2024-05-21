
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="./Styles/Login/login.css">
    <link rel="stylesheet" href="./Styles/footer.css">

    <title> RealState </title>
</head>
<body>

<div class="container-login">



    <div class="content-box">
        <div class="form-box">
            <h2>RealState</h2>
            <form action="login" method="post">
                <div class="input-box">
                    <span>Email:</span>
                    <input id="emailLogin" type="Text" class='reste' name="emailLogin"  placeholder="Seu Email" required/>
                    <div class="mb-3">

                    </div>
                </div>

                <div class="input-box">
                    <span>Senha:</span>
                    <input id="senhaLogin" type="password" name="senhaLogin" placeholder="Sua Senha" required/>

                </div>

                <div class="remember">
                    <label>
                        <input type="checkbox"/> Lembrar de mim
                    </label>
                    <a href="/cadastrouser">Esqueceu a senha?</a>
                </div>

                <div class="input-button">
                    <Button class="btnEntrar">Entrar</Button>
                </div>

                <div class="input-box">
                    <p>Não Tem Uma Conta? <a href="/cadastrouser">Criar</a></p>
                </div>
            </form>
        </div>
    </div>
</div>
<footer class="footer">
    <div class="container-footer">
        <div class="row">

            <div class="footer-col">
                <h4>Alternative menu</h4>

            </div>

            <div class="footer-col">
                <h4>Contact</h4>



            </div>

            <div class="footer-col">
                <h4>Social networks</h4>
                <div class="social-links">

                </div>
            </div>
        </div>
    </div>
</footer>
</body>
