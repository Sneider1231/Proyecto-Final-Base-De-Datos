<template>
  <ion-page style="background-color: white;">
    <Toolbar value="Inicio"></Toolbar>
    <ion-content :fullscreen="true" class="ion-padding ion-text-center">
      <!-- Imagen -->
      <Logo></Logo>
      <!-- Botones -->
      <div style="display: flex; flex-direction: column; align-items: center;">
        <Button href="./todos" value="Ver todos los vehículos disponibles"></Button>
        <Button href="./buscar" value="Buscar vehículos"></Button>
        <Button href="./admin/login" value="Ingresar como administrador"></Button>
      </div>
    </ion-content>
  </ion-page>
</template>

<script setup lang="ts">
import { IonHeader, IonContent, IonPage } from '@ionic/vue';
import Button from '@/components/Button.vue';
import Toolbar from '@/components/Toolbar.vue';
import Logo from '@/components/Logo.vue';
</script>
