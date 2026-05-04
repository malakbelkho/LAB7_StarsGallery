# StarsGallery – LAB 7

Application Android permettant d’afficher une galerie de stars sous forme de liste moderne avec images circulaires, notes, recherche dynamique, partage et modification de rating via popup personnalisé.

## Objectif:
Le but de ce laboratoire est de :
- Comprendre l’utilisation du RecyclerView
- Implémenter un Adapter personnalisé avec le pattern ViewHolder
- Manipuler une architecture Android organisée en couches
- Charger et afficher des images de célébrités
- Mettre en place une recherche dynamique avec SearchView
- Implémenter un filtrage en temps réel grâce à l’interface Filterable
- Créer un Splash Screen animé
- Ajouter une fonctionnalité de partage
- Modifier dynamiquement la note d’une star via une boîte de dialogue personnalisée
- Personnaliser l’interface avec des drawables, gradients, cartes arrondies, badges, couleurs et thèmes

## Description de l’application:
L’application contient :
- Un écran de démarrage animé
- Une galerie de stars affichée avec RecyclerView
- Une barre de recherche personnalisée
- Un bouton de partage
- Un popup permettant de modifier la note d’une star

Dans la liste, chaque star est représentée par :
- Une image circulaire
- Le nom de la star
- Une barre de notation
- Un identifiant affiché sous forme de badge
- Une carte moderne avec coins arrondis

Au clic sur une star :
- Une boîte de dialogue s’affiche
- L’image de la star apparaît
- L’utilisateur peut modifier la note
- La liste est mise à jour automatiquement après validation

## Fonctionnalités:
- Splash Screen animé au lancement de l’application
- Affichage d’une liste dynamique avec RecyclerView
- Utilisation d’un Adapter personnalisé
- Pattern ViewHolder pour optimiser l’affichage
- Affichage d’images circulaires avec CircleImageView
- Recherche instantanée par nom
- Filtrage dynamique avec Filterable
- Partage de l’application avec Intent.ACTION_SEND
- Popup personnalisé pour modifier la note
- Mise à jour visuelle de la liste après modification
- Interface moderne avec :
  - Dégradés doux
  - Header personnalisé
  - Cartes arrondies
  - Badges numériques
  - Images circulaires
  - Couleurs harmonieuses
  - Design coloré et agréable

## Technologies utilisées:
- Android Studio
- Java
- XML
- RecyclerView
- Glide
- CircleImageView
- Material Components
- API minimum : 24 (Android 7.0)

## Aperçu de l’application:

▶️ Une démonstration vidéo complète est disponible dans le dossier **Demo** du repository.

⚠️ En cas de problème de lecture :

👉 [▶️ Voir la démo sur Google Drive](https://your-link)

## Structure du projet:

### Packages Java:

#### beans/Star.java
- Représente une star
- Contient les attributs principaux :
  - id
  - name
  - img
  - star
- Fournit les getters et setters
- Permet de stocker la note et l’image associée à chaque célébrité

#### dao/IDao.java
- Interface générique
- Définit les opérations CRUD :
  - create
  - update
  - delete
  - findById
  - findAll
- Permet de rendre la couche service plus propre et réutilisable

#### service/StarService.java
- Gère les données des stars en mémoire
- Implémente l’interface IDao
- Utilise le pattern Singleton
- Initialise la liste des célébrités
- Permet de rechercher une star par son identifiant
- Permet de modifier la note d’une star

#### adapter/StarAdapter.java
- Adapter personnalisé du RecyclerView
- Relie les données aux vues XML
- Utilise le pattern ViewHolder
- Charge les images des stars
- Affiche le nom, l’image, la note et l’identifiant
- Implémente Filterable pour permettre la recherche
- Gère le clic sur une star
- Affiche un popup pour modifier la note
- Met à jour l’affichage avec notifyItemChanged

#### ui/SplashActivity.java
- Représente l’écran de démarrage
- Lance une animation sur le logo
- Affiche le titre de l’application
- Redirige automatiquement vers ListActivity après quelques secondes

#### ui/ListActivity.java
- Représente l’écran principal
- Initialise le RecyclerView
- Associe l’Adapter à la liste des stars
- Gère la barre de recherche personnalisée
- Applique le filtrage dynamique
- Gère le bouton de partage

### Layouts XML:

#### res/layout/activity_splash.xml
- Écran de démarrage de l’application
- Contient :
  - Logo central
  - Titre Stars Gallery
  - Sous-titre
- Utilise un fond en dégradé doux
- Donne une première impression moderne à l’application

#### res/layout/activity_list.xml
- Écran principal de la galerie
- Contient :
  - Header personnalisé
  - Titre de l’application
  - SearchView
  - Bouton de partage
  - RecyclerView
- Remplace l’ActionBar classique par une interface plus moderne et personnalisée

#### res/layout/star_item.xml
- Représente une ligne du RecyclerView
- Contient :
  - Image circulaire
  - Nom de la star
  - Texte d’indication
  - RatingBar
  - Badge d’identifiant
- Utilise MaterialCardView pour un rendu plus élégant
- Permet de garder une interface claire, moderne et lisible

#### res/layout/star_edit_item.xml
- Layout du popup de modification de note
- Contient :
  - Image de la star
  - RatingBar modifiable
  - Identifiant caché de la star
- Utilisé dans AlertDialog lors du clic sur un élément de la liste

### Ressources de design:

#### res/values/colors.xml
- Centralise les couleurs utilisées dans l’application
- Contient :
  - Couleurs principales
  - Couleurs secondaires
  - Couleurs de fond
  - Couleurs des cartes
  - Couleurs du texte
  - Couleurs des badges
- Facilite la modification globale du design

#### res/values/themes.xml
- Définit le thème principal de l’application
- Utilise un thème sans ActionBar classique
- Permet d’avoir une interface personnalisée avec un header créé dans le layout
- Définit les couleurs de la status bar et de la navigation bar

#### res/values-night/themes.xml
- Définit le thème utilisé en mode sombre
- Garde une cohérence visuelle avec le thème principal
- Permet d’éviter les changements imprévus de couleurs lorsque le téléphone est en dark mode

### Drawables utilisés:

#### res/drawable/bg_splash_screen.xml
- Fond du Splash Screen
- Utilise un dégradé harmonieux clair
- Donne un effet doux et moderne au lancement

#### res/drawable/bg_splash_card.xml
- Carte centrale du Splash Screen
- Coins arrondis
- Bordure douce
- Style moderne et léger

#### res/drawable/bg_main_screen.xml
- Fond principal de l’application
- Dégradé clair permettant de faire ressortir les cartes

#### res/drawable/bg_header_card.xml
- Fond du header principal
- Dégradé rouge/rose
- Donne une identité visuelle forte à l’application

#### res/drawable/bg_search_box.xml
- Fond de la barre de recherche
- Coins arrondis
- Couleur claire pour améliorer la lisibilité

#### res/drawable/bg_circle_icon.xml
- Fond circulaire du bouton de partage
- Permet d’obtenir un bouton simple, propre et élégant

#### res/drawable/bg_id_badge.xml
- Badge affichant l’identifiant de la star
- Forme circulaire
- Bordure douce
- Couleurs adaptées au thème global

#### res/drawable/bg_dialog_content.xml
- Fond du contenu du popup
- Donne une apparence plus propre à la boîte de dialogue
- Améliore la présentation de l’image et de la RatingBar

#### res/drawable/bg_star_item.xml
- Fond personnalisé utilisé pour les premières versions des cartes
- Peut servir de fallback si l’on veut utiliser un LinearLayout au lieu de MaterialCardView
- Définit une carte arrondie avec dégradé léger et bordure douce

## Dépendances utilisées:

```gradle
implementation("androidx.recyclerview:recyclerview:1.3.2")
implementation("de.hdodenhof:circleimageview:3.1.0")
implementation("com.github.bumptech.glide:glide:4.16.0")
annotationProcessor("com.github.bumptech.glide:compiler:4.16.0")
```

## Explication du fonctionnement:

Au lancement de l’application, SplashActivity affiche un écran de démarrage animé. Le logo est animé avec des effets de rotation, de zoom et d’apparition progressive. Après une courte durée, l’utilisateur est redirigé vers ListActivity.

Dans ListActivity, la liste des stars est récupérée depuis StarService. Cette liste est ensuite envoyée à StarAdapter, qui se charge de créer les vues de chaque élément dans le RecyclerView.

La SearchView permet de filtrer la liste en temps réel. À chaque caractère saisi, la méthode getFilter().filter() est appelée dans l’adapter. Le filtre compare le texte saisi avec les noms des stars et met à jour la liste affichée.

Lorsqu’un utilisateur clique sur une star, un AlertDialog personnalisé s’ouvre. Ce popup affiche l’image de la star ainsi qu’une RatingBar. Après validation, la nouvelle note est sauvegardée dans StarService et l’affichage de l’élément est actualisé.

Le bouton de partage utilise un Intent de type ACTION_SEND afin de partager un texte via les applications installées sur le téléphone comme Gmail, WhatsApp ou Messages.

## Concepts Android appliqués:
- RecyclerView
- Adapter personnalisé
- ViewHolder
- Filterable
- SearchView
- Intent implicite
- AlertDialog personnalisé
- Singleton
- DAO générique
- Architecture en couches
- Animations Android
- Ressources drawable
- Fichiers colors.xml et themes.xml
- Design responsive avec XML
- Personnalisation avancée de l’interface

## Conclusion:
Ce laboratoire permet de réaliser une application Android complète, interactive et visuellement moderne en combinant plusieurs notions importantes du développement mobile.

Il met en pratique :
- L’affichage optimisé avec RecyclerView
- La séparation des responsabilités avec une architecture claire
- L’utilisation d’un Adapter personnalisé
- Le filtrage dynamique des données
- L’interaction utilisateur avec un popup personnalisé
- La modification et la mise à jour des notes
- Le partage via Intent
- La personnalisation avancée de l’interface avec XML, drawables, couleurs et thèmes

Ce projet constitue une bonne base pour comprendre la création d’applications Android modernes, structurées, maintenables et visuellement attractives.
