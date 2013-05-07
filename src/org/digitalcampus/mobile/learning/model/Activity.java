/* 
 * This file is part of OppiaMobile - http://oppia-mobile.org/
 * 
 * OppiaMobile is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * OppiaMobile is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with OppiaMobile. If not, see <http://www.gnu.org/licenses/>.
 */

package org.digitalcampus.mobile.learning.model;

import java.io.Serializable;
import java.util.ArrayList;

import org.digitalcampus.mobile.learning.R;
import org.digitalcampus.mobile.learning.utils.ImageUtils;
import org.joda.time.DateTime;

import android.content.res.Resources;
import android.graphics.Bitmap;

public class Activity implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1548943805902073988L;

	public static final String TAG = Activity.class.getSimpleName();
	
	private long modId;
	private int sectionId;
	private int actId;
	private String actType;
	private ArrayList<Lang> titles = new ArrayList<Lang>();
	private ArrayList<Lang> locations = new ArrayList<Lang>();
	private ArrayList<Lang> contents = new ArrayList<Lang>();
	private String digest;
	private String imageFile;
	private ArrayList<Media> media = new ArrayList<Media>();
	private boolean completed = false;
	private boolean customImage = false;
	private DateTime startDate;
	private DateTime endDate;

	public Activity(){
	}
	
	public boolean hasCustomImage(){
		return this.customImage;
	}
	
	public Bitmap getImageFile(String prefix, Resources res) {
		int defaultImage = R.drawable.default_icon_activity;
		if(actType.equals("quiz")){
			defaultImage = R.drawable.default_icon_quiz;
		} else if (actType.equals("page") && this.hasMedia()){
			defaultImage = R.drawable.default_icon_video;
		}
		if(!prefix.endsWith("/")){
			prefix += "/";
		}
		return ImageUtils.LoadBMPsdcard(prefix + this.imageFile, res, defaultImage);
	}

	public void setImageFile(String imageFile) {
		this.imageFile = imageFile;
		this.customImage = true;
	}
	
	public ArrayList<Media> getMedia() {
		return media;
	}

	public void setMedia(ArrayList<Media> media) {
		this.media = media;
	}

	

	public String getDigest() {
		return digest;
	}

	public void setDigest(String digest) {
		this.digest = digest;
	}
	
	public long getModId() {
		return modId;
	}

	public void setModId(long modId) {
		this.modId = modId;
	}

	public int getSectionId() {
		return sectionId;
	}

	public void setSectionId(int sectionId) {
		this.sectionId = sectionId;
	}

	public int getActId() {
		return actId;
	}

	public void setActId(int actId) {
		this.actId = actId;
	}

	public String getActType() {
		return actType;
	}

	public void setActType(String actType) {
		this.actType = actType;
	}


	public String getTitle(String lang) {
		for(Lang l: titles){
			if(l.getLang().equals(lang)){
				return l.getContent();
			}
		}
		if(titles.size() > 0){
			return titles.get(0).getContent();
		}
		return "No title set";
	}
	
	public void setTitles(ArrayList<Lang> titles) {
		this.titles = titles;
	}
	
	public String getLocation(String lang) {
		for(Lang l: locations){
			if(l.getLang().equals(lang)){
				return l.getContent();
			}
		}
		if(locations.size() > 0){
			return locations.get(0).getContent();
		}
		return "No location set";
	}
	
	public void setLocations(ArrayList<Lang> locations) {
		this.locations = locations;
	}
	
	public String getContents(String lang) {
		for(Lang l: contents){
			if(l.getLang().equals(lang)){
				return l.getContent();
			}
		}
		if(contents.size() > 0){
			return contents.get(0).getContent();
		}
		return "No content set";
	}
	
	public void setContents(ArrayList<Lang> contents) {
		this.contents = contents;
	}
	
	public boolean hasMedia(){
		if(media.size() == 0){
			return false;
		} else {
			return true;
		}
	}
	
	public void setCompleted(boolean completed){
		this.completed = completed;
	}
	
	public boolean getCompleted(){
		return this.completed;
	}
	
	public DateTime getStartDate() {
		return startDate;
	}

	public void setStartDate(DateTime startDate) {
		this.startDate = startDate;
	}

	public DateTime getEndDate() {
		return endDate;
	}

	public void setEndDate(DateTime endDate) {
		this.endDate = endDate;
	}
}
