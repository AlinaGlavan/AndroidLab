GIT este un sistem distribuit de control al versiunilor (eng. VCS - Version Control System), un mecanism prin intermediul căruia sunt gestionate proiecte pe măsură ce sunt modificate.
Scopul este de a se putea realiza restaurarea unei versiuni stabile(in caz de eroare) și pentru a permite colaborarea între mai multe echipe care lucrează concomitent la diferite funcționalități ale unui același proiect.
Se va folosi un client GitHub pentru Windows. Acesta este disponibil atât sub forma unei versiuni în linie de comandă (preferabil de utilizat) cât și a unei versiuni care conține o interfață grafică cu utilizatorul.

În cazul în care se dorește monitorizarea unui proiect prin sistemul de control al versiunilor Git, se va inițializa directorul in care se gaseste acesta folosind comanda:
$ git init
Astfel, se creează un director local .git în care vor fi plasate toate versiunile fișierelor care sunt monitorizate. 
Indicarea fișierelor care sunt monitorizate se face prin intermediul comenzii:
$ git add <file>
Prin intermediul acestei comenzi, fișierele sunt transferate din directorul de lucru în zona de așteptare.
Consemnarea propriu-zisă a fișierelor se face rulând comanda 
$ git commit -m "<message>"
Fișierele trec din zona de așteptare în directorul Git.

Pentru a trimite modificarile catre un repo la distanta se vor folosi comenzile(push):
$ git remote add origin https://github.com/USER/RepoName.git
$ git push <remote_name> <branch>
[$ git push -u origin master]

Dacă este necesar ca fișierele modificate să fie încărcate pe serverul de unde au fost preluate, trebuie ca mai întâi să se actualizeze modificările care se vor fi produs pe acesta între timp (rezolvand conflictele) 
$ git pull --rebase 
Apoi se transfera prin comanda 
$ git push origin master


Alte comenzi utile:
$ git status - vizualizare stare fisiere
$ git tag - vizualizarea etichetelor corespunzatoare diferitelor versiuni

Mai mulți utilizatori pot colabora în cadrul unui proiect Git aflat pe un server la distanță. Operațiile pe care le pot realiza sunt descărcarea de cod sursă, respectiv încărcarea (în situația în care au drepturi suficiente).

Descărcarea de cod sursă de pe un depozit la distanță

1.copie a datelor aflate la locația indicată de URL(ramificațiilor, ramificația master), cu monitorizare pentru modificări, astfel încât acestea să fie integrate automat (eng. merged) în codul sursă din directorul de lucru:
$ git clone https://github.com/USER/RepoName.git

2. informațiile din depozitul de pe serverul la distanță care nu se regăsesc pe discul local, creându-se referințe către ramificația de la locația respectivă, care pot fi consultate pentru ca ulterior să fie integrate:
$ git fetch https://github.com/USER/RepoName.git

3. modificările dintr-o ramificație monitorizată din depozitul de pe serverul la distanță, încercând să le integreze în mod automat în codul sursă din directorul de lucru:
$ git pull origin master


Info utile:
https://help.github.com/en/articles/adding-a-file-to-a-repository-using-the-command-line
https://medium.com/code-yoga/how-to-link-android-studio-with-github-312037a13b99
https://product.hubspot.com/blog/git-and-github-tutorial-for-beginners