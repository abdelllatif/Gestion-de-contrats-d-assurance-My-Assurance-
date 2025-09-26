# 🛡️ Assurance Console Application

## 📖 Contexte du projet

Cette application console a été développée pour digitaliser les services d’une compagnie d’assurance. Elle permet à la société de gérer efficacement les conseillers, clients, contrats et sinistres, tout en intégrant les concepts modernes de la programmation Java tels que les **Streams**, **Optional**, et les **expressions lambda**.

L’objectif principal est de créer un outil fonctionnel pour la gestion des assurés et de leurs sinistres, avec une architecture claire et extensible.

---

## ⚙️ Fonctionnalités

### 🧑‍💼 Gestion des conseillers
- ➕ Ajouter un conseiller : génération automatique d’un identifiant unique.
- ❌ Supprimer un conseiller par son ID.
- 🔍 Rechercher un conseiller par son ID.
- 📋 Afficher les clients associés à un conseiller.

### 🧑‍🤝‍🧑 Gestion des clients
- ➕ Ajouter un client : génération automatique d’un identifiant unique et rattachement à un conseiller.
- ❌ Supprimer un client par son ID.
- 🔍 Rechercher un client par nom de famille et tri par ordre alphabétique (Streams API).
- 🔑 Rechercher un client par ID (Optional pour la gestion sécurisée des valeurs nulles).
- 📋 Afficher les clients d’un conseiller donné (Streams API).

### 📄 Gestion des contrats
- ➕ Ajouter un contrat : génération automatique d’un ID et rattachement à un client.
- 🔍 Afficher un contrat par ID (Optional).
- ❌ Supprimer un contrat par ID.
- 📋 Afficher les contrats souscrits par un client donné.

### 💥 Gestion des sinistres
- ➕ Ajouter un sinistre : génération automatique d’un ID et rattachement au contrat correspondant.
- ❌ Supprimer un sinistre par ID.
- 💰 Calculer le coût total des sinistres d’un client (Streams API).
- 🔑 Rechercher un sinistre par ID (Optional).
- 📄 Afficher la liste des sinistres par contrat, par client ou triée par montant (Streams API).
- 📅 Filtrer les sinistres par date ou par montant (Streams API).

---

## 🏗️ Architecture de l’application

### 1️⃣ Couche modèle
- **Person** : nom, prénom, email.
- **Conseiller** : hérite de Person.
- **Client** : hérite de Person et référence un conseiller.
- **Contrat** : id, typeContrat (enum), dateDebut, dateFin, client.
- **Sinistre** : id, typeSinistre (enum), dateTime, coût, description, contrat.

### 2️⃣ Enums
- **TypeContrat** : AUTOMOBILE, MAISON, MALADIE.
- **TypeSinistre** : ACCIDENT_VOITURE, ACCIDENT_MAISON, MALADIE.

### 3️⃣ Couche DAO
- 🛠️ Gestion des interactions avec la base de données via JDBC.
- 📂 Méthodes CRUD pour chaque entité (Client, Contrat, Sinistre).

### 4️⃣ Couche service
- 💡 Contient toute la logique métier.
- 🔄 Implémente CRUD, filtrage et tri des données avec Streams, Optional, et Java Time API.
- 📌 Classes principales :
  - `ConseillerService`
  - `ClientService`
  - `ContratService`
  - `SinistreService`

### 5️⃣ Couche view
- 🖥️ Interface console pour interagir avec l’utilisateur.
- Menu principal et sous-menus pour chaque fonctionnalité :
  - `ClientView`
  - `ContratView`
  - `SinistreView`

### 6️⃣ Couche controller
- 🔗 Intermédiaire entre les views et les services.
- Les contrôleurs appellent les méthodes des services et renvoient les résultats aux views.

---

## 🛠️ Technologies utilisées
- ☕ Java 8 : programmation orientée objet et fonctionnelle.
- 🔄 Streams API & Lambdas : traitement et filtrage des collections.
- 🔑 Optional : gestion sécurisée des valeurs nulles.
- 📅 Java Time API : gestion des dates pour les sinistres et contrats.
- 🗄️ JDBC : communication avec la base de données.
- 🖥️ Console Application : interface textuelle simple et fonctionnelle.

---

## 💡 Concepts clés appliqués
- 🔒 Encapsulation : toutes les propriétés sont privées avec getters et setters.
- 🧩 Programmation fonctionnelle : utilisation de streams, lambdas et method references.
- 🛡️ Gestion sécurisée des valeurs : utilisation d’Optional pour éviter les NullPointerException.
- 🏗️ Architecture en couches : séparation claire entre DAO, Services, Controllers et Views.

---

## 🚀 Utilisation
1. Cloner le projet et importer dans un IDE compatible Java 8.
2. Configurer la connexion JDBC à votre base de données.
3. Exécuter la classe `Main` pour lancer l’application console.
4. Naviguer dans le menu pour gérer les conseillers, clients, contrats et sinistres.

---

## ✅ Avantages
- 📌 Permet une gestion centralisée et structurée des assurés et sinistres.
- 🔄 Application modulable et extensible pour intégrer de nouvelles fonctionnalités.
- ☕ Exploitation des meilleures pratiques Java (fonctionnelle et objet).
