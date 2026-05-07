L’application affiche l’écran principal du compteur LiveData avec une valeur initiale égale à 0. Les boutons permettent d’incrémenter, décrémenter ou réinitialiser la valeur.
<img width="391" height="846" alt="Capture d&#39;écran 2026-05-07 040832" src="https://github.com/user-attachments/assets/f965eca1-791b-4569-bb30-ddf224e4a13b" />

Après plusieurs clics sur le bouton + Incrémenter, la valeur du compteur passe à 6, ce qui montre que LiveData met à jour automatiquement l’interface.
<img width="399" height="848" alt="Capture d&#39;écran 2026-05-07 040840" src="https://github.com/user-attachments/assets/868bdd08-229a-482c-8709-193574a2632d" />

La valeur du compteur est maintenant 3, probablement après l’utilisation du bouton - Décrémenter. L’interface reste synchronisée avec la donnée observée.
<img width="393" height="856" alt="Capture d&#39;écran 2026-05-07 040848" src="https://github.com/user-attachments/assets/c44ab1e9-d26d-42c0-9fa0-f963ed5cb92c" />

Après avoir cliqué sur Réinitialiser, le compteur revient à 0, ce qui confirme le bon fonctionnement de l’action de remise à zéro.
<img width="395" height="853" alt="Capture d&#39;écran 2026-05-07 040859" src="https://github.com/user-attachments/assets/7014739f-ef00-4778-8ccf-41d70dddec4d" />


En mode paysage, l’application conserve son affichage et la valeur du compteur atteint 11. Cela montre que l’interface s’adapte à l’orientation horizontale.
<img width="995" height="473" alt="Capture d&#39;écran 2026-05-07 040938" src="https://github.com/user-attachments/assets/4a280e94-67da-4b16-abda-a47a3d0e9a8c" />


Le compteur reste affiché à 11 en mode paysage, avec les boutons bien alignés horizontalement. L’application garde son état même après changement d’orientation.
<img width="989" height="465" alt="Capture d&#39;écran 2026-05-07 040950" src="https://github.com/user-attachments/assets/cfa9bd60-3c47-413a-a67f-196137b5ab44" />
