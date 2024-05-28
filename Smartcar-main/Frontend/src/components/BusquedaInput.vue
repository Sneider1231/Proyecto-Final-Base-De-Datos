<template>
    <div style="display: flex; flex-direction: column; align-items: start;">
        <!-- Campos para los atributos del vehículo -->
        <ion-list>
            <ion-item>
                <Input v-model="nombre" id="nombre" name="nombre" label="Nombre*:"></Input>
            </ion-item>
            <ion-item>
                <Input v-model="marca" id="marca" name="marca" label="Marca*:"></Input>
            </ion-item>
            <ion-item>
                <Input v-model="modelo" id="modelo" name="modelo" label="Modelo*:"></Input>
            </ion-item>
            <ion-item>
                <Input v-model="ubicacion" id="ubicacion" name="ubicacion" label="Ubicación:"></Input>
            </ion-item>
            <ion-item>
                <Input v-model="anio" type="number" id="anio" name="anio" label="Año*:"></Input>
            </ion-item>
            <ion-item>
                <ion-label>
                    Condición:
                </ion-label>
                    <ion-radio-group v-model="condicion" id="condicion" name="condicion" allow-empty-selection="true">
                        <ion-radio value="Nuevo" label-placement="end">Nuevo</ion-radio>
                        <ion-radio value="Usado" label-placement="end">Usado</ion-radio>
                    </ion-radio-group>
            </ion-item>
            <ion-item>
                <ion-label>
                    Transmisión:
                </ion-label>
                    <ion-radio-group v-model="transmision" id="transmision" name="transmision" allow-empty-selection="true">
                        <ion-radio value="Manual" label-placement="end">Manual</ion-radio>
                        <ion-radio value="Automática" label-placement="end">Automática</ion-radio>
                    </ion-radio-group>
            </ion-item>
            <ion-item>
                <ion-select v-model="tipo" id="tipo" name="tipo" label="Tipo:">
                    <ion-select-option value="Automóvil">Automóvil</ion-select-option>
                    <ion-select-option value="Campero">Campero</ion-select-option>
                    <ion-select-option value="Pick-up">Pick-up</ion-select-option>
                    <ion-select-option value="SUV">SUV</ion-select-option>
                </ion-select>
            </ion-item>
            <ion-item>
                <ion-select v-model="combustible" id="combustible" name="combustible" label="Combustible:">
                    <ion-select-option value="Gasolina">Gasolina</ion-select-option>
                    <ion-select-option value="Diesel">Diesel</ion-select-option>
                    <ion-select-option value="Híbrido">Híbrido</ion-select-option>
                    <ion-select-option value="Eléctrico">Eléctrico</ion-select-option>
                </ion-select>
            </ion-item>
            <ion-item>
                <Input v-model="ultimoDigito" type="number" id="ultimoDigito" name="ultimoDigito"
                    label="Último dígito de placa:"></Input>
            </ion-item>
            <ion-item lines="none">
                <ion-label>Precio</ion-label>
            </ion-item>
            <ion-item lines="none">
                <Input v-model="precioMin" type="precioMin" id="precioMin" name="precioMin" label="Mínimo:"></Input>
            </ion-item>
            <ion-item>
                <Input v-model="precioMax" type="precioMax" id="precioMax" name="precioMax" label="Máximo:"></Input>
            </ion-item>
            <ion-item lines="none">
                <ion-label>Kilometraje</ion-label>
            </ion-item>
            <ion-item lines="none">
                <Input v-model="kilometrajeMin" type="number" id="kilometrajeMin" name="kilometrajeMin"
                    label="Mínimo:"></Input>
            </ion-item>
            <ion-item lines="none">
                <Input v-model="kilometrajeMax" type="number" id="kilometrajeMax" name="kilometrajeMax"
                    label="Máximo:"></Input>
            </ion-item>
        </ion-list>
    </div>
</template>

<script setup lang="ts">
import Input from './Input.vue';
import { IonRadioGroup, IonRadio, IonSelect, IonSelectOption, IonLabel, IonList, IonItem } from '@ionic/vue';
import { ref } from 'vue';

const nombre = ref('');
const marca = ref('');
const modelo = ref('');
const ubicacion = ref('');
const anio = ref('');
const condicion = ref('Usado');
const transmision = ref('');
const tipo = ref('');
const combustible = ref('');
const ultimoDigito = ref('');
const precioMin = ref('');
const precioMax = ref('');
const kilometrajeMin = ref('');
const kilometrajeMax = ref('');
</script>