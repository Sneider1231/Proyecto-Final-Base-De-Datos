<template>
    <div style="display: flex; flex-direction: column; align-items: start;">
        <!-- Campos para los atributos del vehículo -->
        <ion-list>
            <ion-item>
                <Input v-model="vehiculo.nombre" id="nombre" name="nombre" label="Nombre*:"></Input>
            </ion-item>
            <ion-item>
                <Input v-model="vehiculo.marca" id="marca" name="marca" label="Marca*:"></Input>
            </ion-item>
            <ion-item>
                <ion-textarea v-model="vehiculo.descripcion" id="descripcion" name="descripcion"
                    label="Descripción*: "></ion-textarea>
            </ion-item>
            <ion-item>
                <Input v-model="vehiculo.modelo" id="modelo" name="modelo" label="Modelo*:"></Input>
            </ion-item>
            <ion-item>
                <Input v-model="vehiculo.ubicacion" id="ubicacion" name="ubicacion" label="Ubicación:"></Input>
            </ion-item>
            <ion-item>
                <Input v-model="vehiculo.anio" type="number" id="anio" name="anio" label="Año*:"></Input>
            </ion-item>
            <ion-item>
                <ion-label>
                    Condición:
                </ion-label>
                <ion-radio-group v-model="vehiculo.condicion" id="condicion" name="condicion" allow-empty-selection="true">
                    <ion-radio value="Nuevo" label-placement="end">Nuevo</ion-radio>
                    <ion-radio value="Usado" label-placement="end">Usado</ion-radio>
                </ion-radio-group>
            </ion-item>
            <ion-item>
                <ion-label>
                    Transmisión:
                </ion-label>
                <ion-radio-group v-model="vehiculo.transmision" id="transmision" name="transmision" allow-empty-selection="true">
                    <ion-radio value="Manual" label-placement="end">Manual</ion-radio>
                    <ion-radio value="Automática" label-placement="end">Automática</ion-radio>
                </ion-radio-group>
            </ion-item>
            <ion-item>
                <ion-select v-model="vehiculo.tipo" id="tipo" name="tipo" label="Tipo*:">
                    <ion-select-option value="Automóvil">Automóvil</ion-select-option>
                    <ion-select-option value="Campero">Campero</ion-select-option>
                    <ion-select-option value="Pick-up">Pick-up</ion-select-option>
                    <ion-select-option value="SUV">SUV</ion-select-option>
                </ion-select>
            </ion-item>
            <ion-item>
                <ion-select v-model="vehiculo.combustible" id="combustible" name="combustible" label="Combustible:">
                    <ion-select-option value="Gasolina">Gasolina</ion-select-option>
                    <ion-select-option value="Diesel">Diesel</ion-select-option>
                    <ion-select-option value="Híbrido">Híbrido</ion-select-option>
                    <ion-select-option value="Eléctrico">Eléctrico</ion-select-option>
                </ion-select>
            </ion-item>
            <ion-item>
                <Input v-model="vehiculo.ultimoDigito" type="number" id="ultimoDigito" name="ultimoDigito"
                    label="Último dígito de placa:"></Input>
            </ion-item>
            <ion-item>
                <Input v-model="vehiculo.precio" type="number" id="precio" name="precio" label="Precio*:"></Input>
            </ion-item>
            <ion-item>
                <Input v-model="vehiculo.kilometraje" type="number" id="kilometraje" name="Kilometraje"
                    label="Kilometraje:"></Input>
            </ion-item>
            <ion-item lines="none">
                <Input v-model="vehiculo.imagen" type="file" id="imagen" name="imagen" label="Imagen:"></Input>
                <!-- No guarda la imagen sino una url inválida -->
            </ion-item>
            <ion-item>
                <ion-img v-if="imagen" :src="`data:image/jpeg;base64,${imagen}`"></ion-img>
                <ion-label v-else>Imagen no disponible</ion-label>
            </ion-item>
            <ion-item>
                <ion-label>*Campos obligatorios</ion-label>
            </ion-item>
        </ion-list>
    </div>
</template>

<script setup lang="ts">
import Input from './Input.vue';
import { IonRadioGroup, IonRadio, IonTextarea, IonSelect, IonSelectOption, IonLabel, IonImg, IonList, IonItem } from '@ionic/vue';
import { ref } from 'vue';

const props = defineProps(['vehiculo']);

const imagen = ref('');
</script>