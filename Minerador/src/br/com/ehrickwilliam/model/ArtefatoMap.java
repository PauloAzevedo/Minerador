/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ehrickwilliam.model;

/**
 *
 * @author Erick
 */
public class ArtefatoMap {

    public static String verificarComponenteDoArtefato(String diretorio) {
        String retorno;
        switch (diretorio) {
            case "basic":
                retorno = "BASIC";
                break;
            case "basctl":
                retorno = "BASIC";
                break;
            case "chart2":
                retorno = "Chart";
                break;
            case "connectivity":
                retorno = "Database";
                break;
            case "configmgr":
                retorno = "Database";
                break;
            case "dbaccess":
                retorno = "Database";
                break;
            case "drawinglayer":
                retorno = "Drawing";
                break;
            case "extensions":
                retorno = "Extensions";
                break;
            case "sot":
                retorno = "filters and storage";
                break;
            case "xmlsecurity":
                retorno = "filters and storage";
                break;
            case "test":
                retorno = "sdk";
                break;
            case "starmath":
                retorno = "Formula Editor";
                break;
            case "framework":
                retorno = "framework";
                break;
            case "wizards":
                retorno = "framework";
                break;
            case "ucbhelper":
                retorno = "framework";
                break;
            case "binfilter":
                retorno = "filters and storage";
                break;
            case "lotuswordpro":
                retorno = "filters and storage";
                break;
            case "extras":
                retorno = "UI";
                break;
            case "accessibility":
                retorno = "UI";
                break;
            case "icon-themes":
                retorno = "UI";
                break;
            case "offapi":
                retorno = "sdk";
                break;
            case "qadevOOo":
                retorno = "sdk";
                break;
            case "formula":
                retorno = "sdk";
                break;
            case "forms":
                retorno = "UI";
                break;
            case "desktop":
                retorno = "Libreoffice";
                break;
            case "filter":
                retorno = "filters and storage";
                break;
            case "xmloff":
                retorno = "filters and storage";
                break;
            case "testautomation":
                retorno = "sdk";
                break;
            case "default_images":
                retorno = "UI";
                break;
            case "sd":
                retorno = "Drawing";
                break;
            case "io":
                retorno = "framework";
                break;
            case "svx":
                retorno = "graphics stack";
                break;
            case "linguistic":
                retorno = "Linguistic";
                break;
            case "l10ntools":
                retorno = "Localization";
                break;
            case "slideshow":
                retorno = "Presentation";
                break;
            case "sdext":
                retorno = "Presentation";
                break;
            case "odk":
                retorno = "Extensions";
                break;
            case "sc":
                retorno = "Spreadsheet";
                break;
            case "uui":
                retorno = "UI";
                break;
            case "dmake":
                retorno = "UI";
                break;
            case "svtools":
                retorno = "UI";
                break;
            case "ooo_custom_images":
                retorno = "UI";
                break;
            case "cui":
                retorno = "UI";
                break;
            case "readlicense_oo":
                retorno = "Installation";
                break;
            case "scp2":
                retorno = "Installation";
                break;
            case "instsetoo_native":
                retorno = "Installation";
                break;
            case "sw":
                retorno = "Writer";
                break;
            case "swext":
                retorno = "Writer";
                break;
            case "writerfilter":
                retorno = "Writer";
                break;
            case "writerperfect":
                retorno = "Writer";
                break;
            default:
                retorno = diretorio;

        }
        return retorno;
    }
}
