<?xml version="1.0" encoding="ISO-8859-1"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns="http://www.w3.org/TR/REC-html40">

	<xsl:template match="/">
		<HTML>
		<HEAD>
		  <TITLE>Chronotha Exportation</TITLE>
		</HEAD>
		<BODY>
		<xsl:apply-templates/>
		</BODY>
		</HTML>
	</xsl:template>
	
	<xsl:template match="holidays" >
		<ul>
			<li>
			Weekend : <xsl:value-of select="formattedDate"/> <br />
			</li>
		</ul>
	</xsl:template>
	
	<xsl:template match="workingDays" >
		<ul>
			<li>Date : <xsl:value-of select="formattedDate"/> </li>
			<li>Séances :<xsl:value-of select="seances"/></li>
			<xsl:apply-templates/>
		</ul>
	</xsl:template>
	
	<xsl:template match="seances" >
		<ul>
			<li>Début : <xsl:value-of select="debut"/> </li>
			<li>Durée : <xsl:value-of select="duree"/> </li>
			<li>Formateur : <xsl:value-of select="formateur"/> </li>
			<li>Module : <xsl:value-of select="module"/> </li>
			<xsl:apply-templates/>
		</ul>
	</xsl:template>
	
	
	<xsl:template match="formateur" >
		<ul>
			<li>Nom : <xsl:value-of select="nom"/> </li>
			<li>Prénom : <xsl:value-of select="prenom"/> </li>
			<li>Titre : <xsl:value-of select="titre"/> </li>
			<li>Email : <xsl:value-of select="email"/></li>
		</ul>
		<xsl:apply-templates/>
	</xsl:template>
	
	<xsl:template match="module" >
		<ul>
			<li>
			  <xsl:attribute name="style">
			    background-color:#<xsl:value-of select="color"/>
			  </xsl:attribute>
				Nom de module : <xsl:value-of select="name"/>
			</li>
			<li>Nombre de séances : <xsl:value-of select="nbSeance"/> </li>
			<xsl:apply-templates/>
		</ul>
	</xsl:template>

</xsl:stylesheet>