# Chronotha
Academic use: a calandrial planning management tool
ESIAG - Projet IHM de L3 2014-2015
Le projet
Le projet a pour objectif de consolider compétences en IHM et bonnes pratiques de développement,
en réalisant une application swing.
Organisation
Le projet sera réalisé par groupes de 3. Un unique groupe de 4 ou de 2 sera accepté en cas de nombre
d'étudiants non multiple de 3.
Le projet de chaque groupe sera sous gestion de version, avec un dépôt git ou svn public sur le Web
(github, google code), dont les seuls contributeurs seront les membres du groupe. Il est recommandé
d'utiliser netbeans ou eclipse pour le développement. Séparez sources et tests unitaires : les sources
seront dans un dossier src, et les tests unitaires dans un dossier test (une classe
modele.UneClasse sera dans le dossier src, sa classe de test modele.UneClasseTest sera
dans le dossier test) ; netbeans le fait automatiquement, avec eclipse c'est manuel.
Le délégué de chaque promotion enverra à votre responsable de projet (Michel Plasse
michel.plasse@u-pec.fr) la liste des groupes (rédigée par exemple via google document) avant le 20
février 2015. Pour chaque groupe, indiquer prénom, nom et email de chaque membre, et url du dépôt
git ou svn public.
La soutenance aura lieu fin mai : le 23 pour les L3 2/3 A et B, et le 29 pour les L3 FI. Prévoir une
démonstration (répétez-là avec des données préalablement choisies, cela évite l'effet démo).
Rendu
Chaque groupe enverra à l'adresse michel.plasse@u-pec.fr, au plus tard la fin de semaine précédant
la soutenance, un zip nommé NOM1Prenom1_NOM2Prenom2_NOM3Prenom3.zip dans l'ordre
alphabétique des noms des membres du groupe (ex : BERNERSLEE.
Tim_MEYER.Bertrand_TURING.Alan.zip dans le cas du trinôme Tim BERNERS LEE, Bertand
MEYER et Alan TURING).
Le zip contiendra (directement sous la racine) :
Le projet 1. netbeans ou eclipse intégral.
2. Le jar du projet. L'application pourra être lancée par java -jar chemin_du_jar.jar.
Un fichier readme.pdf, décrivant votre organisation, votre conception (organisation et rôle de
vos classes, choix de conception, difficultés rencontrées, aides obtenues avec url quand sur le
Web, solutions retenues), et la répartition des tâches.
3.
Le fichier fonctionnalites-projet-ihm.xlsx disponible sur l'intranet, où vous aurez
indiqué pour chaque tests fonctionnel s'il est validé (saisir 1) ou pas (saisir 0).
4.
Un rapport de tests unitaires tests.pdf, affichant l'intégralité des tests du projet avec leur
réussite ou pas (impression écran).
5.
Les éléments qui ne seraient pas où il est demandé seront considérés comme manquants, je ne
perdrai pas de temps à les chercher.
Tout retard sera sanctionné de deux points par jour de retard.
ESIAG - Projet IHM de L3 2014-2015
1
Evaluation
Elle tiendra compte des éléments suivants :
Richesse fonctionnelle.
Pour avoir la moyenne, les quatre premières fonctionnalités demandées devront être
implémentées et satisfaire les tests fonctionnels associés.
Les suivantes apportent des points en plus. Leur ordre est indicatif.
Qualité de la conception et du code : séparation modèle/IHM, utilisation à bon escient de
schémas de conception (observateur/observé amélioré, modèle-vue-contrôleur, fabrique,
commande).
Respect des bonnes pratiques : tests fonctionnels, tests unitaires, gestion de version, petits
cycles incrémentaux, documentation (javadoc + choix de conception).
Pas de tests unitaires : 5 points en moins.
Pas de gestion de version (pas de git ou svn, ou pas de commit sur le dépôt du projet) : 5
points en moins.
Ergonomie : l'utilisateur prend facilement en main l'application (IHM intuitive), chaque tâche
nécessite un minimum d'actions de sa part (IHM pratique), il est guidé de façon à lui éviter des
erreurs et reçoit un feedback immédiat et précis, etc.
Un travail équitablement réparti entre les membres d'un groupe leur donne une note identique. En cas
de déséquilibre, les notes seront individualisées.
Application à développer
Objectif
Un petit centre de formation demande un outil pour gérer son planning le plus facilement possible.
Celui-ci est actuellement sour forme d'un fichier excel exporté en pdf sur l'intranet. Excel est facile à
utiliser, mais n'empêche pas de planifier un formateur sur deux séances simultanées, ou deux séances
simultanées dans la même salle. De même, il n'extrait pas automatiquement les séances d'un formateur
sous forme d'une liste ou de iCalendar, le format d'échange des calendriers.
Il existe des produits complets sur le marché, mais, destinés à de grands centres, ils sont onéreux et
lourds à utiliser.
Fonctionnalités
Le centre n'a que quelques salles et quelques formations en parallèle (moins de 7). Une seule personne
(le gestionnaire) a le planning en charge, et l'exporte sur l'intranet du centre.
Les fonctionnalités souhaitées pour la version 1 sont listées par ordre de priorité, avec le bénéfice
attendu, et les tests fonctionnels (tests d'acceptation) associés. Les 4 premières sont obligatoires pour
avoir la moyenne.
Créer, afficher, sauver et ouvrir un planning vierge, de septembre à août, pour une année donnée.
Toutes les formations de l'année partageront ce modèle.
Bénéfice : éviter du travail de saisie au gestionnaire, et avoir une base fiable.
Tests :
Une colonne par jour de la semaine, deux lignes par semaine (une pour le matin, une pour
l'après-midi).
1.
Une fois l'année choisie, les jours 2. sont créés automatiquement.
1.
ESIAG - Projet IHM de L3 2014-2015
2
Prise 3. en compte des années bisextiles.
Pouvoir marquer comme non ouvré/ouvré des jours et des colonnes (samedi et dimanche).
Les jours non ouvrés ne pourront pas recevoir de cours.
4.
5. Le planning peut être sauvé dans un fichier (stockage binaire).
6. Les jours non ouvrés sont récupérés quand on rouvre ce planning.
Configurer pour une formation son nom, la durée type d'une séance et la liste de ses modules (ex
: Java, BD), avec leur nombre d'heures.
Bénéfice : encadrer la saisie des séances, et garantir sa cohérence.
Nous supposons avoir seulement une formation dans l'année.
Tests :
1. Chaque module a un nom, une abbréviation, une couleur, un nombre de séances.
2. Ces données sont modifiables pour chaque module.
3. Les modules ont une couleur, un nom et une abbréviation distincts des autres.
4. Sauver le planning de l'année sauve ces données.
5. La durée en heures est affichée pour chaque module.
6. La durée totale de la formation en nombre de jours et d'heures est affiché.
2.
Placer sur un jour une séance d'un module, ou l'enlever.
Bénéfice : besoin central de l'application.
Tests :
1. La séance porte l'information du module.
La séance porte l'indication n/m, où m est le nombre de séances du module et n est le rang
de la séance dans ce module.
2.
3. La séance ne peut faire référence qu'à un module existant dans la formation.
Si le nombre de séances créées d'un module dépasse le nombre prévu, l'indiquer
précisément.
1. L'indication reste affichée tant que l'erreur n'est pas corrigée.
2. Elle disparait quand l'erreur est corrigée.
3. La saisie d'autres séances de ce module reste possible.
4.
5. Sauver le planning sauve toutes ses séances : on les retrouve quand on l'ouvre à nouveau.
3.
Exporter en HTML le planning.
Bénéfice : pouvoir l'afficher sur l'intranet.
Tests :
Un titre (h1) avec le nom de la formation (il s'agit plus en fait d'une promotion), l'année
(ex : 2014-2015), le nombre d'heures total.
1.
2. Les séances sont dans un tableau de même forme qu'en swing.
Chaque séance indique l'abréviation du module, son rang/le nombre de séances du module,
et a la couleur de fond associée au module.
3.
4.
Défaire/refaire l'édition d'une séance.
Bénéfice : sérénité du travail, le gestionnaire sait qu'en cas d'erreur, il peut revenir à un état
antérieur, comme dans n'importe quel éditeur.
Tests :
Ajouter une séance peut être défait.
1. Refaire ajoute à nouveau la séance, avec toutes ses données.
1.
2. Idem pour modifier.
3. Idem pour supprimer.
4. Raccourcis Ctr-Z pour défaire, et Ctr-Y pour refaire.
5.
Copier/coller ou couper/coller une séance.
Bénéfice : faciliter la saisie.
Tests :
1. Coller une séance peut être défait/refait.
2. Toutes les informations de la séance sont conservées, sauf le rang.
Le rang de toutes les séances du module concerné est mis à jour. Celui de la dernière
séance sera ainsi incrémenté de un.
3.
4. Coller une séance remplace la cible, si elle était remplie.
6.
ESIAG - Projet IHM de L3 2014-2015
3
Il est inutile de demander confirmation : en cas d'erreur, le gestionnaire défait son action.
Si coller une séance remplace la cible, toutes les séances de même module que la séance
remplacée voient leur rang mis à jour.
5.
Si coller une séance fait dépasser le nombre de séances prévu pour le module, l'indiquer (cf
point 4 du scénario 3).
6.
Editer plusieurs formations pour la même année.
Bénéfice : cohérence des jours ouvrés, qui sont partagés.
Tests :
Toutes les formations de la même 1. année ont les mêmes jours ouvrés.
Ajouter ou supprimer un jour ouvré dans une formation se répercute sur toutes les autres
formations.
2.
Supprimer un jour ouvré qui porte une séance dans une formation est interdit dans toutes
les formations de l'année.
3.
Ouvrir le planning de l'année ouvre toutes les formations qu'elle comporte (ex : une par
onglet).
4.
7.
Associer une séance à un formateur.
Bénéfice : vérifier automatiquement qu'un formateur n'est pas prévu sur plusieurs séances au
même moment
Tests :
1. Un formateur est défini par un email, un téléphone, des initiales, un nom, un prénom.
La liste des formateurs est un paramètre de l'application : elle est persistante lorsqu'on
ferme l'application.
2.
3. Impossible de supprimer un formateur ayant une séance dans l'année.
4. Alerter sans bloquer si un formateur est prévu sur deux séances simultanées.
5. L'alerte doit rester visible tant que le conflit n'est pas résolu, et disparaitre alors.
8.
Exporter en HTML le planning de chaque formateur.
Bénéfice : avoir automatiquement un planning formateur, et être assuré qu'il est valide, cohérent
avec le planning de la ou des formations.
Tests :
1. Lister uniquement les semaines où le formateur intervient.
2. Pour chaque séance, indiquer formation et module.
3. Export pour un formateur
4. Export pour tous les formateurs (un fichier par formateur).
9.
Documentation disponible
En plus des recherches google que vous pouvez faire, pensez à consulter :
Les supports du cours de L3 Programmation avancée et IHM en Java.
Les tutoriels de developpez.com, notamment http://baptiste-wicht.developpez.com/tutoriels
/java/swing/jtable/ .
Ceux de open class room.
ESIAG - Projet IHM de L3 2014-2015
4
