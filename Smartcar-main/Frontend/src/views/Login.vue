<template>
  <ion-page style="background-color: white;">
    <Toolbar value="Iniciar sesión" atras="true" refAtras="./inicio"></Toolbar>
    <ion-content :fullscreen="true" class="ion-padding ion-text-center">
      <!-- Imagen -->
      <Logo></Logo>
      <!-- Cuadro de ingreso -->
      <Input v-model="usuario" id="usuario" name="usuario" label="Usuario:"></Input>
      <Input v-model="contrasenia" type="password" id="contrasenia" name="contrasenia" label="Contraseña:"></Input>
      <!-- Botón para ingresar -->
      <Button @click="log" nameMethod="log" value="Ingresar"></Button>
    </ion-content>
  </ion-page>
  <ion-alert :is-open="mostrarAlerta" header="Acceso denegado" message="Revise los datos ingresados."
    :buttons="alertButtons" @didDismiss="setOpen(false)"></ion-alert>
</template>

<script setup lang="ts">
import { IonHeader, IonContent, IonPage, IonAlert } from '@ionic/vue';
import Button from '@/components/Button.vue';
import Toolbar from '@/components/Toolbar.vue';
import Logo from '@/components/Logo.vue';
import Input from '@/components/Input.vue';
import { onMounted, ref } from 'vue';
import axios from 'axios';
import Swal from 'sweetalert2';

// Rutas de la API
const baseURL = 'http://localhost:8080/smartcar/administrador';

const items = ref<Array<ItemType>>([]);
const usuario = ref('');
const contrasenia = ref('');
const mostrarAlerta = ref(false);
const alertButtons = ['Aceptar'];

const setOpen = (state: boolean) => {
  mostrarAlerta.value = state;
};

let permiso: Boolean;
let admins: Array<ItemType>;

// Tipos
interface ItemType {
  id: string;
  usuario: string;
  contrasenia: string;
}

onMounted(() => {
  findAllRecords();
});

// Obtener todos los registros
async function findAllRecords() {
  try {
    const response = await axios.get(baseURL);
    items.value = response.data;
    return response.data;
  } catch (error) {
    console.error('Error al obtener todos los registros:', error);
    throw error;
  }
}

async function acceder() {
  const data = {
    usuario: usuario.value,
    contrasenia: contrasenia.value
  };

  try {
    permiso = false;
    admins = items.value
    admins.forEach(element => {
      if ((element.usuario === data.usuario) && (element.contrasenia === data.contrasenia)) {
        permiso = true;
      }
    });
    if (permiso) {
      await updateReferencia(data);
      window.location.href = "./admin/inicio";
    } else {
      setOpen(true);
    }
  } catch (error) {
    console.error("Error en la autenticación", error);
  }

}
// Actualizar registro de referncia
async function updateReferencia(data) {
  try {
    await axios.put(`${baseURL}/1`, data);
  } catch (error) {
    console.error('Error al actualizar el registro de referencia:', error);
  }
}

const log = () => {
  acceder();
}
</script>
