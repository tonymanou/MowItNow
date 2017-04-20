MowItNow
========

La société MowItNow a décidé de développer une tondeuse à gazon automatique, destinée aux surfaces rectangulaires.
La tondeuse peut être prog rammée pour parcourir l'intégralité de la surface.

La position de la tondeuse est représentée par une combinaison de coordonnées (x,y) et d'une lettre indiquant
l'orientation selon la notation cardinale anglaise (N,E,W,S).

La pelouse est divisée en grille pour simplifier la navigation.
Par exemple, la position de la tondeuse peut être « 0, 0, N », ce qui signifie qu'elle se situe dans le coin inférieur gauche de la pelouse, et orientée vers le Nord.

Pour
contrôler
la
tondeuse,
on
lui
envoie
une
séquence
simple
de
lettres.
Les
lettres
possibles
sont
« D »,
« G »
et
« A ».
« D »
et
« G »
font
pivoter
la
tondeuse
de
90°
à
droite
ou
à
gauche
respectivement,
sans
la
déplacer.
« A »
signifie
que
l'on
avance
la
tondeuse
d'une
case
dans
la
direction à laquelle elle fait fa
ce, et sans modi
fier son or
ientation.
Si
la
position
après
mouvement
est
en
dehors
de
la
pelouse,
la
tondeuse
ne
bouge
pas,
conserve son orientation et
 traite la comma
nde sui
vante.
On assume que la case directement a
u Nord de la position (x, y) a pour coordonnées (x, y+1).
Pour programmer la tondeu
se, on lui fournit un fichier d'entrée const
ruit comme
 suit :
●
La
première
ligne
correspond
aux
coordonnées
du
coin
supérieur
droit
de
la
pelouse,
celles
du coin inférieur gauche sont supposées être (0,0)
●
La
suite
du
fichier
permet
de
piloter
toutes
les
tondeuses
qui
ont
été
déployées.
Chaque
tondeuse a deux lignes 
la concer
nant :
●
la
première
ligne
donne
la
position
initiale
de
la
tondeuse,
ainsi
que
son
orientation.
La
position
et
l'orientat
ion
sont
fournies
sous
la
forme
de
2
chiffres
et
une
lettre,
séparés
par un espace
●
la
seconde
ligne
est
une
série
d'instructions
ordonna
nt
à
la
tondeuse
d'explorer
la
pelouse. Les instructi
ons sont une sui
te de ca
ractères sans espaces.
Chaque
tondeuse
se
déplace
de
façon
séquenti
elle,
ce
qui
signifie
que
la
seconde
tondeuse
ne
bouge que lorsque la premièr
e a exécuté i
ntégralement sa
 série d'instructions.
Lorsqu'une
tondeuse
achève
une
série
d'instruction,
elle
communique
sa
position
et
son
orientation.
OBJECTIF
Concevoir
et
écrire
un
programme
s'exécuta
nt
sur
une
JVM
et
implémentant
la
spécification
ci-dessus et passant le test
 ci-après
TEST
Le fichier suivant est fourni
 en entr
ée :
5 5
1 2 N
GAGAGAGAA
3 3 E
AADAADADDA
On attend le résultat suivan
t (position finale des tondeuses)
 :
1 3 N
5 1 E
NB:
Les
données
en
entrée
peuvent
être
injectée
sous
une
autre
forme
qu'un
fichier
(par
exemple un test automatisé)
.
